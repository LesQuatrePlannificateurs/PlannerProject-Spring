package com.spring.planner.entities;

import javax.persistence.*;

/**
 * This is the Class of the Person Student.
 * It extends from the Super class de Person.
 * Student principal attribute for the is there StudentClass.
 * This Attribute refer to there Grade and special class of there grade
 * @See StudentClass.name.
 */
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

    public Student(String login, String password, String firstname, String lastname,StudentClass studentClass) {
        super(login, password, firstname, lastname);
        this.studentClass = studentClass;
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



