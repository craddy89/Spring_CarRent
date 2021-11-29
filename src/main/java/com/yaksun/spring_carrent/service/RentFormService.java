package com.yaksun.spring_carrent.service;

import com.yaksun.spring_carrent.model.entity.RentForm;

import java.util.List;

public interface RentFormService {

    void save(RentForm rentForm, String username, Long ID, String price);

    List<RentForm> findAllForms();

    RentForm findById(Long id);

    List<RentForm> findFormsByUsername(String Username);
}

