package com.yaksun.spring_carrent.repository;

import com.yaksun.spring_carrent.model.entity.Ticket;
import com.yaksun.spring_carrent.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Modifying
    @Query(value = "UPDATE Ticket u SET u.status = :status where u.id = :id")
    void changeTicket(@Param("id") Long id, @Param("status") Status status);
}