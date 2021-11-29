package com.yaksun.spring_carrent.model.DTO;

import com.yaksun.spring_carrent.model.enums.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RentFormDTO {

    private Long id;

    private Long carid;

    private String username;

    private ReviewStatus status;

    private String passport;

    private String price;

    private String driver;

    private Date fromDate;

    private Date toDate;
}
