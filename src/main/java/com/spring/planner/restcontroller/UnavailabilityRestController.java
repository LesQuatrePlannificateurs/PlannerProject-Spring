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

    // Ne fonctionne pas, à reprendre
    @RequestMapping(value="/udpateunavailability/{id}", method = RequestMethod.POST)
    public Unavailability updateUnavailability(Unavailability unavailability, @PathVariable Long id){
        return unavailabilityService.updateUnavailability(unavailability,id);
    }


}
