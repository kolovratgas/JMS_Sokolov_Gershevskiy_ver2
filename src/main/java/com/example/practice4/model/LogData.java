package com.example.practice4.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "log_data")
@Table(name = "log_data")
@Data
public class LogData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "class_name")
    private String classname;

    @Column(name = "type_change")
    private String typechange;

    @Column(name = "value")
    private String value;

}
