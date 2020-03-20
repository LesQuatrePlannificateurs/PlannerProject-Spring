package com.spring.planner.entities;

import javax.persistence.*;

/**
 * This is the Class about the room where Students will have their lessons with a Professor.
 * Each classroom is insert in a table named classrooom on the dataBase.
 */
@Entity
@Table(name="classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Classroom() {
    }

    public Classroom(String name){
        this.name=name;
    }
    public Classroom(Long id, String name) {
    this.id = id;
    this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
