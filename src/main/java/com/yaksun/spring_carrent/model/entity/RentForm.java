package com.yaksun.spring_carrent.model.entity;

import com.yaksun.spring_carrent.model.enums.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="rentform")
public class RentForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "carid")
    private Long carid;

    @Column(name = "username")
    private String username;

    @Column(name = "passport")
    private String passport;

    @Column(name = "price")
    private String price;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private ReviewStatus status;

    @Column(name="driver")
    private String driver;

    @Column(name="from_date")
    private Date fromDate;

    @Column(name="to_date")
    private Date toDate;
}
