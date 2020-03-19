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


    //Ne fonctionne pas, à reprendre
    public Unavailability updateUnavailability(Unavailability unavailabilityToUpdate, Long id){
        Unavailability unavailability = unavailabilityRepository.findById(id).orElse(null);
        unavailability.setNameIndispo(unavailabilityToUpdate.getNameIndispo());
        unavailability.setStart(unavailabilityToUpdate.getStart());
        unavailability.setEnd(unavailabilityToUpdate.getEnd());
        unavailability.setProfId(unavailabilityToUpdate.getProfId());
        unavailability.setClassroomId(unavailabilityToUpdate.getClassroomId());
        unavailability.setEquipmentId(unavailabilityToUpdate.getEquipmentId());
        return unavailabilityRepository.save(unavailability);
    }

}
