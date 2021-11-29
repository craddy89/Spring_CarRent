package com.yaksun.spring_carrent.service;


import com.yaksun.spring_carrent.model.entity.User;
import com.yaksun.spring_carrent.model.enums.CarClass;
import com.yaksun.spring_carrent.model.enums.Status;

import java.util.List;

public interface AdminService {

    void deleteCarById(Long id);

    List<User> findAllUsers();

    void updateStatus(Long id, Status status);

    void updateCar(Long id, String model, String brand, CarClass class_, String price);
}

