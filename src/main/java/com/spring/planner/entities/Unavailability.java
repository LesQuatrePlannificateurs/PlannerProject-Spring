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
    Date start;
    Date end;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
