package com.yaksun.spring_carrent.model.DTO;

import com.yaksun.spring_carrent.model.enums.Role;
import com.yaksun.spring_carrent.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private Role role;
    private Status status;

}

