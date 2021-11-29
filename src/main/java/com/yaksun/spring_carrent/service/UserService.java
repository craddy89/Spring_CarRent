package com.yaksun.spring_carrent.service;

import com.yaksun.spring_carrent.model.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
