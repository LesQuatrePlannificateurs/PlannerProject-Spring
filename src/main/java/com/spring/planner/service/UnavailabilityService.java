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

    public Unavailability updateUnavailability(Unavailability unavailability, Long id){
        Unavailability unavailability1 = this.findUnavailabilityById(id);
        unavailability1.setNameIndispo(unavailability.getNameIndispo());
        unavailability1.setStart(unavailability.getStart());
        unavailability1.setEnd(unavailability.getEnd());
        unavailability1.setProfId(unavailability.getProfId());
        unavailability1.setClassroomId(unavailability.getClassroomId());
        unavailability1.setEquipmentId(unavailability.getEquipmentId());
        unavailability1.setStudentClassId(unavailability.getStudentClassId());
        return unavailabilityRepository.save(unavailability1);
    }

    /**
     * Delete an unavailability thanks to its id
     * @param id unavailability's id to delete
     */
    public void deleteUnavailabilityById(Long id){
        Unavailability unavailability = unavailabilityRepository.findById(id).orElse(null);
        unavailabilityRepository.delete(unavailability);
    }

    /**
     * Find a specific unavailability thanks to its id
     * @param id of the unavailability to find
     * @return return the specific unavailability
     */
    public Unavailability findUnavailabilityById(Long id){
        return unavailabilityRepository.findById(id).orElse(null);
    }

}
