package com.yaksun.spring_carrent.service.implementation;

import com.yaksun.spring_carrent.model.entity.User;
import com.yaksun.spring_carrent.model.enums.ReviewStatus;
import com.yaksun.spring_carrent.model.enums.Role;
import com.yaksun.spring_carrent.model.enums.Status;
import com.yaksun.spring_carrent.repository.RentFormRepository;
import com.yaksun.spring_carrent.repository.UserRepository;
import com.yaksun.spring_carrent.service.ManagerService;
import com.yaksun.spring_carrent.service.RentFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private final RentFormRepository rentFormRepository;

    public ManagerServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RentFormService rentFormService, RentFormRepository rentFormRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.rentFormRepository = rentFormRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.MANAGER);
        user.setStatus(Status.PERMITTED);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void changeFormStatus(Long id, ReviewStatus status) {
        rentFormRepository.changeFormStatus(id, status);
    }
}