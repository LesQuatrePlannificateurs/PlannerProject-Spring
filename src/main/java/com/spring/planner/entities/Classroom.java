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
    private Long classroomId;
    private String name;

    public Classroom() {
    }

    public Classroom(String name){
        this.name=name;
    }

    public Long getId() {
        return classroomId;
    }

    public void setId(Long id) {
        this.classroomId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
