package com.yaksun.spring_carrent.service.implementation;

import com.yaksun.spring_carrent.model.entity.RentForm;
import com.yaksun.spring_carrent.model.enums.ReviewStatus;
import com.yaksun.spring_carrent.repository.RentFormRepository;
import com.yaksun.spring_carrent.service.RentFormService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentFormServiceImpl  implements RentFormService {

    final
    RentFormRepository rentFormRepository;

    public RentFormServiceImpl(RentFormRepository rentFormRepository) {
        this.rentFormRepository = rentFormRepository;
    }

    @Override
    public void save(RentForm rentForm, String username, Long ID, String price) {
        rentForm.setStatus(ReviewStatus.INREVIEW);
        rentForm.setCarid(ID);
        rentForm.setUsername(username);
        rentForm.setPrice(price);
        rentFormRepository.save(rentForm);
    }

    @Override
    public List<RentForm> findAllForms() {
        return rentFormRepository.findAll();
    }

    @Override
    public List<RentForm> findFormsByUsername(String Username) {
        List<RentForm> forms = new ArrayList<>();
        List<RentForm> allforms = findAllForms();
        for (RentForm allform : allforms)
            if (allform.getUsername().equals(Username)) forms.add(allform);
        return forms;
    }

    @Override
    public RentForm findById(Long id) {
        return rentFormRepository.findById(id).get();
    }
}

