package com.spring.planner.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="classroom")
public class Classroom extends Item {
    public Classroom(Long id, String name) {
    super.id = id;
    super.name = name;
    }


}
