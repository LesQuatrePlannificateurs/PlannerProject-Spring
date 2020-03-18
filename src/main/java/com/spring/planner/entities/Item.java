package com.spring.planner.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public abstract class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String name;

}
