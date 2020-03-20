package com.spring.planner.entities;

import javax.persistence.*;

@Entity
@Table
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @ManyToOne
    @JoinColumn(name="studentClassId")
    StudentClass studentClass;

    public Student() {
        super();
    }

    public Student(String login, String password, String firstname, String lastname) {
        super(login, password, firstname, lastname);
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }
}



