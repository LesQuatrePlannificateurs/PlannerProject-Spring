package com.spring.planner.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="unavalabilities")
public class Unavailability {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String nameIndispo;
    String start = new Date().toString();
    String end = new Date().toString();
    Long profId;
    Long classroomId;
    Long equipmentId;



    public Unavailability(String nameIndispo) {
        this.nameIndispo = nameIndispo;
    }

    public Unavailability() {
    }

    public Unavailability(Long profId) {
        this.profId = profId;
    }

    public Long getProfId() {
        return profId;
    }

    public void setProfId(Long profId) {
        this.profId = profId;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
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
