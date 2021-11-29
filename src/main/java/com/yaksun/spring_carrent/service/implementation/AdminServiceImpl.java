package com.yaksun.spring_carrent.service.implementation;

import com.yaksun.spring_carrent.model.entity.User;
import com.yaksun.spring_carrent.model.enums.CarClass;
import com.yaksun.spring_carrent.model.enums.Status;
import com.yaksun.spring_carrent.repository.AdminCarRepository;
import com.yaksun.spring_carrent.repository.AdminUserRepository;
import com.yaksun.spring_carrent.repository.UserRepository;
import com.yaksun.spring_carrent.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminUserRepository adminUserRepository;

    @Autowired
    AdminCarRepository adminCarRepository;

    public AdminServiceImpl(UserRepository userRepository, AdminUserRepository adminUserRepository, AdminCarRepository adminCarRepository) {
        this.userRepository = userRepository;
        this.adminUserRepository = adminUserRepository;
        this.adminCarRepository = adminCarRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteCarById(Long id) {
        adminCarRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateStatus(Long id, Status status) {
        adminUserRepository.changeUserStatus(id, status);
    }

    @Override
    public void updateCar(Long id, String model, String brand, CarClass class_, String price) {
    }
}
