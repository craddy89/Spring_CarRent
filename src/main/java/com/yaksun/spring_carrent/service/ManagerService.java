package com.yaksun.spring_carrent.service;

import com.yaksun.spring_carrent.model.entity.User;
import com.yaksun.spring_carrent.model.enums.ReviewStatus;

public interface ManagerService {

    void save(User user);

    User findByUsername(String username);

    void changeFormStatus(Long id, ReviewStatus status);
}
