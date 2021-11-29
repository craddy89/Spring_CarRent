package com.yaksun.spring_carrent.service.implementation;

import com.yaksun.spring_carrent.model.entity.User;
import com.yaksun.spring_carrent.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw (new UsernameNotFoundException(username));
        Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();
        String ROLE_PREFIX = "ROLE_";
        grantedAuthority.add(new SimpleGrantedAuthority(ROLE_PREFIX + user.getRole().getAuthority()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthority);
    }
}

