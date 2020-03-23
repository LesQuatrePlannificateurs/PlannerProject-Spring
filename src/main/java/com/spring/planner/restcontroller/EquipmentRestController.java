package com.spring.planner.restcontroller;

import com.spring.planner.entities.Equipment;
import com.spring.planner.entities.Unavailability;
import com.spring.planner.service.EquipmentService;
import com.spring.planner.service.UnavailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
public class EquipmentRestController {

    @Autowired
    EquipmentService equipmentService;
    @Autowired
    UnavailabilityService unavailabilityService;


    @RequestMapping(value = "/equipmentsplanning/{id}")
    public List<Unavailability> findUnavailabilitiesByEquipmentId(@PathVariable("id")Long id){
        return unavailabilityService.findUnavailabilityByEquipmentId(id);
    }

    @RequestMapping(value = "/addequipments")
    public Equipment addEquipment(@RequestBody Equipment equipment){
        return equipmentService.addEquipment(equipment);
    }

    @RequestMapping(value = "/deleteequipments/{id}")
    public void deleteEquipmentById(@PathVariable("id") Long id){
        equipmentService.deleteEquipmentById(id);
    }

}
