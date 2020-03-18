package com.spring.planner.restcontroller;

import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Unavailability;
import com.spring.planner.service.ClassroomService;
import com.spring.planner.service.UnavailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomRestController {

    @Autowired
    UnavailabilityService unavailabilityService;
    @Autowired
    ClassroomService classroomService;

    //fonctionne dans postman !
    @RequestMapping("/classroomPlanning/{id}")
    public List<Unavailability> getPlanningClassroom(@PathVariable("id")Long id){
        List unaList = unavailabilityService.findUnavailibilityByClassroomId(id) ;
        return unaList;
    }


    //fonctionne dans postman !
    @RequestMapping(value = "/addunavailability", method = RequestMethod.POST)
    public Unavailability addUnavailability(@RequestBody Unavailability unavailability){
        return unavailabilityService.addUnavailability(unavailability);
    }

    //fonctionne dans postman !
    @RequestMapping("/deleteunavailability/{id}")
    public void deleteUnavailabilityById(@PathVariable("id")Long id){
        unavailabilityService.deleteUnavailabilityById(id);

    }

    //fonctionne dans postman !
    @RequestMapping("/classroom/{id}")
    public Classroom findClassroomById(@PathVariable("id")Long id){
        return classroomService.findClassroombyId(id);
    }

    //Fonctionne dans postman !
    @RequestMapping(value = "/addclassroom", method = RequestMethod.POST)
    public Classroom addClassroom(@RequestBody Classroom classroom){
        return classroomService.addClassroom(classroom);
    }

    //Fonctionne dans postman !
    @RequestMapping("/deleteclassroom/{id}")
    public void deleteClassroom(@PathVariable("id")Long id){
        classroomService.deleteClassroom(id);
    }

    //Fonctionne dans postman !
    @RequestMapping("/getallclassrooms")
    public List<Classroom> getAllClassrooms(){
        return classroomService.getAllClassroom();
    }

}
