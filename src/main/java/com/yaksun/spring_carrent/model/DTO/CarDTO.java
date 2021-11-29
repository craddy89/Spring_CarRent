package com.yaksun.spring_carrent.model.DTO;


import com.yaksun.spring_carrent.model.enums.CarClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CarDTO {

    private Long id;
    private String brand;
    private String model;
    private String price;
    private CarClass class_;
    private String status;

}

