package com.spring.planner.entities;

import javax.persistence.*;

/**
 * This is the super Class abstract of Person.
 * It extends Director, Professor and Student Class.
 * In addition to the attributes of Person this class has a Long directorId attribute
 * This attribute refer to the id of director object
 */
@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Person {


    String login;
    String password;
    String firstname;
    String lastname;

    public Person(){
    }

    public Person(String login, String password,String firstname, String lastname){
        this.login=login;
        this.password=password;
        this.firstname=firstname;
        this.lastname=lastname;
    }
//
//    public Long getId() {
//        return pid;
//    }
//
//    public void setId(Long id) {
//        this.pid = id;
//    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
