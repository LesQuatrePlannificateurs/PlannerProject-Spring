package com.spring.planner.restcontroller;

import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Student;
import com.spring.planner.entities.StudentClass;
import com.spring.planner.entities.Unavailability;
import com.spring.planner.service.ClassroomService;
import com.spring.planner.service.StudentClassService;
import com.spring.planner.service.UnavailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class StudentClassRestController {
    @Autowired
    StudentClassService studentClassService;
    @Autowired
    UnavailabilityService unavailabilityService;

    /**
     * Get the student class grade's planning thanks to the student class grade Id
     * @param studentClassId id of the specific classroom
     * @return a list of unavailabilities for this classroom
     */
    @RequestMapping("/student-classPlanning/{id}")
    public List<Unavailability> getPlanningStudentClass(@PathVariable("id")Long studentClassId){
        List unaList = unavailabilityService.findUnavailibilityByStudentClassId(studentClassId) ;
        return unaList;
    }

    /**
     * find a specific classroom thanks to its id
     * @param id id of the specific studentClass
     * @return a studentClass
     */
    @RequestMapping("/student-class/{id}")
    public StudentClass findStudentClassById(@PathVariable("id")Long id){
        return studentClassService.findStudentClassById(id);
    }

    /**
     * Add a studentClass
     * @param studentClass to add
     * @return the added studentClass
     */
    @RequestMapping(value = "/addstudentClass", method = RequestMethod.POST)
    public StudentClass addStudentClass(@RequestBody StudentClass studentClass){
        return studentClassService.addStudentClass(studentClass);
    }

    /**
     * Delete a studentCass thanks to its id
     * @param id of the studentCLass to delete
     */
    @RequestMapping("/deletestudentClass/{id}")
    public void deleteStudentClass(@PathVariable("id")Long id){
        studentClassService.deleteStudentClass(id);
    }

    /**
     * Get all the studentClass grade
     * @return a list of all studentClass grade
     */
    @RequestMapping("/getallstudentclass")
    public List<StudentClass> getAllStudentClass(){
        return studentClassService.getAllStudentCLass();
    }

}

