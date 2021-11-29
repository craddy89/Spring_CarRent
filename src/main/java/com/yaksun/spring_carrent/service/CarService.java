package com.yaksun.spring_carrent.service;

import com.yaksun.spring_carrent.model.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {

    void save(Car car);

    List<Car> findAllCars();

    List<Car> findAllCars(String sort);

    Page<Car> findAllCars(String sort, Pageable pageable);

    void changeCarStatus(Long Id, String status);
}
