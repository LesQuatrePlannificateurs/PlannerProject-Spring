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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class RoomRestController {


    @Autowired
    ClassroomService classroomService;
    @Autowired
    UnavailabilityService unavailabilityService;

    /**
     * Get a specific Classroom planning thanks to the classroom Id
     * @param id id of the specific classroom
     * @return a list of unavailabilities for this classroom
     */
    @RequestMapping("/classroomsPlanning/{id}")
    public List<Unavailability> getPlanningClassroom(@PathVariable("id")Long id){
        List unaList = unavailabilityService.findUnavailibilityByClassroomId(id) ;
        return unaList;
    }

    /**
     * find a specific classroom thanks to its id
     * @param id id of the specific classroom
     * @return a classroom
     */
    @RequestMapping("/classrooms/{id}")
    public Classroom findClassroomById(@PathVariable("id")Long id){
        return classroomService.findClassroombyId(id);
    }

    /**
     * Add a classroom
     * @param classroom to add
     * @return the added classroom
     */
    @RequestMapping(value = "/addclassroom", method = RequestMethod.POST)
    public Classroom addClassroom(@RequestBody Classroom classroom){
        return classroomService.addClassroom(classroom);
    }

    /**
     * Delete a classroom thanks to its id
     * @param id of the classroom to delete
     */
    @RequestMapping("/deleteclassrooms/{id}")
    public void deleteClassroom(@PathVariable("id")Long id){
        classroomService.deleteClassroom(id);
    }

    /**
     * Get all the classrooms
     * @return a list of all classrooms
     */
    @RequestMapping("/getallclassrooms")
    public List<Classroom> getAllClassrooms(){
        return classroomService.getAllClassroom();
    }

}
