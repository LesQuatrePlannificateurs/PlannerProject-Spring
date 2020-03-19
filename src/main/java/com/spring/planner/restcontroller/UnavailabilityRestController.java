package com.spring.planner.restcontroller;

import com.spring.planner.entities.Unavailability;
import com.spring.planner.service.UnavailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UnavailabilityRestController {

    @Autowired
    UnavailabilityService unavailabilityService;


    /**
     * Add an unavailability
     * @param unavailability to add
     * @return the added unavailabitily
     */
    @RequestMapping(value = "/addunavailability", method = RequestMethod.POST)
    public Unavailability addUnavailability(@RequestBody Unavailability unavailability){
        return unavailabilityService.addUnavailability(unavailability);
    }

    /**
     * Delete an unavailability thanks to its Id
     * @param id ud of the unavailability to delete
     */
    @RequestMapping("/deleteunavailability/{id}")
    public void deleteUnavailabilityById(@PathVariable("id")Long id){
        unavailabilityService.deleteUnavailabilityById(id);

    }


    @RequestMapping(value="/udpateunavailability/{id}", method = RequestMethod.POST)
    public Unavailability updateUnavailability(@RequestBody Unavailability unavailability, @PathVariable Long id){
        Unavailability unavailability1 = unavailabilityService.findUnavailabilityById(id);
        unavailability1.setNameIndispo(unavailability.getNameIndispo());
        unavailability1.setStart(unavailability.getStart());
        unavailability1.setEnd(unavailability.getEnd());
        unavailability1.setProfId(unavailability.getProfId());
        unavailability1.setClassroomId(unavailability.getClassroomId());
        unavailability1.setEquipmentId(unavailability.getEquipmentId());
        unavailability1.setStudentClassId(unavailability.getStudentClassId());
        return unavailabilityService.addUnavailability(unavailability1);
    }

}
