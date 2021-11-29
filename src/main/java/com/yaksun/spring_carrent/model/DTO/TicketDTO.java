package com.yaksun.spring_carrent.model.DTO;

import com.yaksun.spring_carrent.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TicketDTO {
    Long id;
    Long carid;
    Long price;
    String username;
    Status status;
}

