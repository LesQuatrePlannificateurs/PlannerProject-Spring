package com.spring.planner.entities;

import javax.persistence.*;

@Entity
@Table(name="professor")
public class Professor extends Person {


    public Professor() {
        super();
    }

    public Professor(String login, String psw, String firstname, String lastname){
        super(login,psw,firstname,lastname);
    }



}
