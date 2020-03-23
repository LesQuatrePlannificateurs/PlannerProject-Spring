package com.spring.planner.entities;

import javax.persistence.*;

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
