package com.spring.planner.entities;

import javax.persistence.*;

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
