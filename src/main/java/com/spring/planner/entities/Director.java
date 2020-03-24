package com.spring.planner.entities;

import javax.persistence.*;

/**
 * This is the Class of the Director Person.
 * It extends from the Super class Person.
 * In addition to the attributes of Person this class has a Long directorId attribute
 * This attribute refer to the id of director object
 */
@Entity
@Table(name = "director")
public class Director extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long directorId;

    public Director(){
    }
    public Director(String login, String psw, String firstname, String lastname){
        super(login,psw,firstname,lastname);
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }
}
