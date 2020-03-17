package com.spring.planner.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public abstract class  Unavailability {

    Long id;
    String nameIndispo;
    Date startUnavailability;
    Date endUnavailability;


}
