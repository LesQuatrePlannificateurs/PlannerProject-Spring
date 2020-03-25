package com.spring.planner.entities;

import javax.persistence.*;

/**
 * This is the Class about the required equipment of classroom to have lessons with a Professor.
 * Each equipment is insert in a table named equipment on the dataBase.
 * This class has a Long equipmentId attribute
 * This attribute refer to the id of equipment object
 * This class has a String equipmentName attribute
 * This attribute refer to the name of equipment object
 */
@Entity
@Table(name="equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentId;
    private String equimpentName;

    public Equipment(){
    }
    public Equipment(String equimpentName){
        this.equimpentName=equimpentName;
    }


    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquimpentName() {
        return equimpentName;
    }

    public void setEquimpentName(String equimpentName) {
        this.equimpentName = equimpentName;
    }
}
