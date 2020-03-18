package com.spring.planner.entities;

import javax.persistence.*;

@Entity
@Table(name="classroom")
public class Classroom extends Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    public Classroom() {
    }

    public Classroom(Long id, String name) {
    super.id = id;
    super.name = name;
    }


}
