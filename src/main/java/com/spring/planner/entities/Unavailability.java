package com.spring.planner.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
/**
 * This is the Unavailability class
 * It is the central point of lessons management
 * Each Professor will be able to assign a lesson to a schedule slot.
 * All unavailabilities will be saved in a table of the database.
 * Unavailability is characterized by the following information:
 * <ul>
 * <li>Un identifiant unique généré automatiquement.</li>
 * <li>A name, most often representing a type of course.</li>
 * <li>A moment (date + hour) of start and end.</li>
 * <li>A prof ID.</li>
 * </ul>
 * </br> It can Contain possibly :
 * <ul>
 * <li>A Classroom ID</li>
 * <li>An equiment ID, use during professor's Lessons</li>
 * </ul>
 * </p>
 *
 */
@Entity
@Table
public class Unavailability {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String nameIndispo;
    String start;
    String end;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "professorId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Professor professor;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "classroomId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Classroom classroom;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="studentClassId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    StudentClass studentClass;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "equipmentId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Equipment equipment;



    public Unavailability() {
    }


    public Unavailability(String nameIndispo, String start, String end, Professor professor, Classroom classroom,StudentClass studentClass, Equipment equipment) {

        this.nameIndispo = nameIndispo;
        this.start = start;
        this.end = end;
        this.professor = professor;
        this.classroom = classroom;
        this.studentClass = studentClass;
        this.equipment = equipment;

    }
    public Unavailability(String nameIndispo, String start, String end, Professor professor, Classroom classroom,StudentClass studentClass) {

        this.nameIndispo = nameIndispo;
        this.start = start;
        this.end = end;
        this.professor = professor;
        this.classroom = classroom;
        this.studentClass = studentClass;

    }


    public StudentClass  getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameIndispo() {
        return nameIndispo;
    }

    public void setNameIndispo(String nameIndispo) {
        this.nameIndispo = nameIndispo;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
