package com.yaksun.spring_carrent.controller;

import com.yaksun.spring_carrent.model.entity.RentForm;
import com.yaksun.spring_carrent.model.entity.Ticket;
import com.yaksun.spring_carrent.model.enums.ReviewStatus;
import com.yaksun.spring_carrent.service.ManagerService;
import com.yaksun.spring_carrent.service.RentFormService;
import com.yaksun.spring_carrent.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_MANAGER')")
public class ManagerController {

    @Autowired
    TicketService ticketService;

    @Autowired
    RentFormService rentFormService;

    @Autowired
    ManagerService managerService;

    @GetMapping("/manager_confirm")
    public String home(Model model) {
        List<RentForm> forms = rentFormService.findAllForms();
        model.addAttribute("forms", forms);
        return "manager_confirm";
    }

    @PostMapping("/{id}/ACCEPTED")
    public String StatusAccept(@PathVariable String id){
        Long sId = Long.valueOf(id);
        managerService.changeFormStatus(sId, ReviewStatus.ACCEPTED);
        Ticket ticket = new Ticket();
        ticketService.save(ticket, rentFormService.findById(sId));
        return "redirect:/manager_confirm";
    }

    @PostMapping("/{id}/REJECTED")
    public String StatusReject(@PathVariable String id){
        Long sId = Long.valueOf(id);
        managerService.changeFormStatus(sId, ReviewStatus.REJECTED);
        return "redirect:/manager_confirm";
    }
}
