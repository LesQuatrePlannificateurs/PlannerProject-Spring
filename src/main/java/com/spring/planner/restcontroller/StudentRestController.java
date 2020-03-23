package com.spring.planner.restcontroller;

import com.spring.planner.entities.Student;
import com.spring.planner.entities.StudentClass;
import com.spring.planner.entities.Unavailability;
import com.spring.planner.service.StudentClassService;
import com.spring.planner.service.StudentService;
import com.spring.planner.service.UnavailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class StudentRestController {
    @Autowired
    StudentClassService studentClassService;
    @Autowired
    StudentService studentService;
    @Autowired
    UnavailabilityService unavailabilityService;

    @RequestMapping(value="studentPlanning/{id}")
    public List<Unavailability> getPlanningStudent(@PathVariable("id")Long studentId){
        Student student = studentService.findStudentById(studentId);
        return unavailabilityService.findUnavailibilityByStudentClassId(student.getStudentClass().getStudentClassId());
    }

    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @RequestMapping(value = "/findstudent/{id}")
    public Student findStudentById(@PathVariable("id") Long id){
        return studentService.findStudentById(id);
    }

    @RequestMapping(value = "/deletestudent/{id}")
    public void deletestudentById(@PathVariable("id")Long id){
        studentService.deleteStudentById(id);
    }

    @RequestMapping(value="allstudentByClassId/{id}")
    public List<Student> getAllStudentsByStudentClassId(Long studentClassId){
        StudentClass studentClass = studentClassService.findStudentClassById(studentClassId);
        return studentService.getAllStudentByStudentClassId(studentClassId);
    }
}

// allStudent byStudentClass