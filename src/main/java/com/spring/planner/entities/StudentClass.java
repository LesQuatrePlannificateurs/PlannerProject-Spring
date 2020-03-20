package com.spring.planner.entities;

import javax.persistence.*;

@Entity
@Table
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentClassId;
    private String name;

    public StudentClass() {
    }
    public StudentClass(String name) {
        this.name = name;
    }
    public Long getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(Long studentClassId) {
        this.studentClassId = studentClassId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
