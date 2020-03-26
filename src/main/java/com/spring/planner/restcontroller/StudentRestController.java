package com.spring.planner.restcontroller;

import com.spring.planner.entities.Student;
import com.spring.planner.entities.StudentClass;
import com.spring.planner.entities.Unavailability;
import com.spring.planner.service.StudentClassService;
import com.spring.planner.service.StudentService;
import com.spring.planner.service.UnavailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/apiStudent")
public class StudentRestController {
    @Autowired
    StudentClassService studentClassService;
    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @RequestMapping(value = "/findstudent/{id}")
    public Student findStudentById(@PathVariable("id") Long id){
        return studentService.findStudentById(id);
    }
    @RequestMapping(value = "/findstudentlogin/{login}")
    public Student findStudentById(@PathVariable("login") String login){
        return studentService.findStudentByLogin(login);
    }

    @RequestMapping(value = "/deletestudent/{id}")
    public void deletestudentById(@PathVariable("id")Long id){ studentService.deleteStudentById(id);
    }

    @RequestMapping(value="allstudentByClassId/{id}")
    public List<Student> getAllStudentsByStudentClassId(@PathVariable("id")Long studentClassId){
        return studentService.getAllStudentByStudentClassId(studentClassId);
    }
}
