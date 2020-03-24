package com.spring.planner.entities;

import javax.persistence.*;

/**
 * This is the Student's grade class.
 * Each student will be attribute to one grade and the special name of their grade.
 * Professor will have to attribute there lessons to a grade and especially named grade like 5ème'B'
 * name,
 * where 'B' is the special attribute of the grade. That is beacause classRoom can contains no more than
 * 25 students for a lesson.
 */
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
