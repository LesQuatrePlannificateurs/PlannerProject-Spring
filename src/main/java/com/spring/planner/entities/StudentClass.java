package com.spring.planner.entities;

import javax.persistence.*;

@Entity
@Table
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentClassId;
    private String name;
}
