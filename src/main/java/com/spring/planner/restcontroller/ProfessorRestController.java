package com.spring.planner.restcontroller;

import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Professor;
import com.spring.planner.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class ProfessorRestController {

    @Autowired
    ProfessorService professorService;

    @RequestMapping(value = "/addprofessor", method = RequestMethod.POST)
    public Professor addProfessor(@RequestBody Professor professor){
        return professorService.addProfessor(professor);
    }

}
