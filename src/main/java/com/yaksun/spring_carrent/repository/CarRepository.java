package com.yaksun.spring_carrent.repository;

import com.yaksun.spring_carrent.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Modifying
    @Query(value = "UPDATE Car u SET u.status = :status where u.id = :id")
    void changeCarStatus(@Param("id") Long id, @Param("status") String status);


}

