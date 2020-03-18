package com.spring.planner.service;


import com.spring.planner.entities.Unavailability;
import com.spring.planner.repository.UnavailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnavailabilityService {

    @Autowired
    UnavailabilityRepository unavailabilityRepository;


    public List findUnavailibilityByClassroomId(Long id) {
        return (List) unavailabilityRepository.findUnavailabilityByClassroomId(id);
    }

    public Unavailability addUnavailability(Unavailability unavailability){
        return unavailabilityRepository.save(unavailability);
    }

    public void deleteUnavailabilityById(Long id){
        Unavailability unavailability = unavailabilityRepository.findById(id).orElse(null);
        unavailabilityRepository.delete(unavailability);
    }

}
