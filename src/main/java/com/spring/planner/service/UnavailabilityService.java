package com.spring.planner.service;


import com.spring.planner.entities.Unavailability;
import com.spring.planner.repository.UnavailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnavailabilityService {

    @Autowired
    UnavailabilityRepository unavailabilityRepository;

    /**
     * find all unavailabilities for a specific Classroom
     * @param id of the classroom
     * @return a list of unavailabilities for this classroom Id
     */
    public List findUnavailibilityByClassroomId(Long id) {
        return (List) unavailabilityRepository.findUnavailabilityByClassroomId(id);
    }

    /**
     * Add an unavailability
     * @param unavailability to add
     * @return the added unavailability
     */
    public Unavailability addUnavailability(Unavailability unavailability){
        return unavailabilityRepository.save(unavailability);
    }

    /**
     * Delete an unavailability thanks to its id
     * @param id to delete
     */
    public void deleteUnavailabilityById(Long id){
        Unavailability unavailability = unavailabilityRepository.findById(id).orElse(null);
        unavailabilityRepository.delete(unavailability);
    }

    public Unavailability findUnavailabilityById(Long id){
        return unavailabilityRepository.findById(id).orElse(null);
    }

}
