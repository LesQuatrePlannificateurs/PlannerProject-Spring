package com.spring.planner.entities;

import java.util.List;

public abstract class Item {
    Long id;
    String name;
    List<Unavailability> unavailabilityList;
}
