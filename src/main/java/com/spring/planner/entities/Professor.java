package com.spring.planner.entities;

import javax.persistence.*;

/**
 * This is the Class of the Professor Person.
 * It extends from the Super class Person.
 * In addition to the attributes of Person this class has a Long professorId attribute
 * This attribute refer to the id of professor object
 */
@Entity
@Table(name="professor")
public class Professor extends Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long professorId;

    public Professor() {
        super();
    }

    public Professor(String login, String psw, String firstname, String lastname){
        super(login,psw,firstname,lastname);
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }
}
