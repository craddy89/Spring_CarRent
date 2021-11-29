package com.yaksun.spring_carrent.model.entity;

import com.yaksun.spring_carrent.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "carid")
    Long carid;

    @Column(name = "price")
    Long price;

    @Column(name = "username")
    String username;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    Status status;
}
