package com.yaksun.spring_carrent.service.implementation;

import com.yaksun.spring_carrent.model.entity.User;
import com.yaksun.spring_carrent.model.enums.Role;
import com.yaksun.spring_carrent.model.enums.Status;
import com.yaksun.spring_carrent.repository.CarRepository;
import com.yaksun.spring_carrent.repository.UserRepository;
import com.yaksun.spring_carrent.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, CarRepository carRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setStatus(Status.PERMITTED);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
