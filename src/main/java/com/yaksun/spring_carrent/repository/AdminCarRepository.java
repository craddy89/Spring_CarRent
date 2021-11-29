package com.yaksun.spring_carrent.repository;

import com.yaksun.spring_carrent.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCarRepository extends JpaRepository<Car, Long> {

}
