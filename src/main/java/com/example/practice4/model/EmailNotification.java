package com.example.practice4.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "email_notification")
@Table(name = "email_notification")
@Data
public class EmailNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "condition")
    private String condition;
}
