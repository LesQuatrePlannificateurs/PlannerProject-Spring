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

<<<<<<< HEAD

=======
    /**
     * Update an existing unavailability
     * @param unavailability is the update unavailability
     * @param id is the id of the unavailability we want to update
     * @return the updated unavailability
     */
>>>>>>> 15811da4806e4fc80a16593ea2be6eab209b6958
    @RequestMapping(value="/udpateunavailability/{id}", method = RequestMethod.POST)
    public Unavailability updateUnavailability(@RequestBody Unavailability unavailability, @PathVariable Long id){
        return unavailabilityService.updateUnavailability(unavailability,id);
    }

}
