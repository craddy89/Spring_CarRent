package com.yaksun.spring_carrent.repository;

import com.yaksun.spring_carrent.model.entity.User;
import com.yaksun.spring_carrent.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = "UPDATE User u SET u.status = :status where u.id = :id")
    void changeUserStatus(@Param("id") Long id, @Param("status") Status status);

}
