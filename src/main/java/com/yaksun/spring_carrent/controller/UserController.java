package com.yaksun.spring_carrent.controller;

import com.yaksun.spring_carrent.model.DTO.RentFormDTO;
import com.yaksun.spring_carrent.model.DTO.UserDTO;
import com.yaksun.spring_carrent.model.entity.Car;
import com.yaksun.spring_carrent.model.entity.RentForm;
import com.yaksun.spring_carrent.model.entity.Ticket;
import com.yaksun.spring_carrent.model.entity.User;
import com.yaksun.spring_carrent.model.enums.Status;
import com.yaksun.spring_carrent.repository.CarRepository;
import com.yaksun.spring_carrent.repository.UserRepository;
import com.yaksun.spring_carrent.service.*;
import com.yaksun.spring_carrent.validator.RentFormValidator;
import com.yaksun.spring_carrent.validator.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private CarService carService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;
    //admin
    @Autowired
    private ManagerService managerService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private RentFormService rentFormService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private RentFormValidator rentFormValidator;

    @GetMapping("/home")
    public String home(@PageableDefault(page = 0, size = 5)
                       @SortDefault.SortDefaults({
                               @SortDefault(sort = "brand", direction = Sort.Direction.ASC),
                               @SortDefault(sort = "id", direction = Sort.Direction.DESC)
                       })
                               Pageable pageable, Model model){
        Page<Car> cars = carService.findAllCars("sort", pageable);
        model.addAttribute("cars", cars);
        return "home";
    }


    @GetMapping("/")
    public String home2(Model model) {
        List<Car> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
        return "home";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserDTO userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        User user = mapper.map(userForm, User.class);
        userService.save(user);
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if(error != null) {
            model.addAttribute("error","login.error");
        }

        if(logout != null) {
            model.addAttribute("message","login.out");
        }

        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "redirect:/login";
    }

    @GetMapping("/{id}/rental")
    public String CarEdit(Model model, @PathVariable String id) {
        model.addAttribute("rentForm", new RentFormDTO());
        model.addAttribute("id", id);
        long currentTime=System.currentTimeMillis();
        Date currentDate = new Date(currentTime);
        model.addAttribute("date", currentDate);
        return "rental";
    }

    @PostMapping("/{id}/rental")
    public String CarEdit(Authentication authentication, @ModelAttribute("rentForm") RentFormDTO rentForm,
                          BindingResult bindingResult, @PathVariable String id) {
        rentFormValidator.validate(rentForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/{id}/rental";
        }
        Long sId = Long.valueOf(id);
        int dr = 0;
        if (rentForm.getDriver().equals("Driver"))
        {
            dr = 1;
        }
        long days = TimeUnit.DAYS.convert(rentForm.getToDate().getTime() - rentForm.getFromDate().getTime(), TimeUnit.MILLISECONDS) + 1;
        Long price = (long) (((int) Double.parseDouble(carRepository.findById(sId).get().getPrice()) * 100 + dr * 4000) / 100) * days;
        String username = authentication.getName();
        RentForm rentForm1 = mapper.map(rentForm, RentForm.class);
        rentFormService.save(rentForm1, username, sId, String.valueOf(price));
        carService.changeCarStatus(sId, "RENTED");
        return "redirect:/home";
    }

    @GetMapping("/usercabinet")
    public String cabinet(Authentication authentication, Model model) {
        List<RentForm> forms = rentFormService.findFormsByUsername(authentication.getName());
        model.addAttribute("forms", forms);
        List<Ticket> tickets = ticketService.findTicketsByUsername(authentication.getName());
        model.addAttribute("tickets", tickets);
        return "usercabinet";
    }

    @PostMapping("/{id}/PAY")
    public String StatusReject(@PathVariable Long id){
        ticketService.changeTicketStatus(id, Status.PAYED);
        return "redirect:/usercabinet";
    }
}
