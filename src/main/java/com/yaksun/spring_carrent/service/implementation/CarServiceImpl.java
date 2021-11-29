package com.yaksun.spring_carrent.service.implementation;

import com.yaksun.spring_carrent.model.entity.Car;
import com.yaksun.spring_carrent.repository.CarRepository;
import com.yaksun.spring_carrent.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void save(Car car) {
        car.setStatus("AVAILABLE");
        carRepository.save(car);
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findAllCars(String sort) {
        if(sort != null){
            return carRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, sort));
        }
        return findAllCars();
    }

    @Override
    @Transactional
    public void changeCarStatus(Long Id, String status) {
        carRepository.changeCarStatus(Id, status);
    }

    @Override
    public Page<Car> findAllCars(String sort, Pageable pageable) {
        return carRepository.findAll(pageable);
    }
}
