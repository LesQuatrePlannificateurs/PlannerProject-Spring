package com.spring.planner.entities;

import javax.persistence.*;

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
