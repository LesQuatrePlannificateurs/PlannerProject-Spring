package com.spring.planner.restcontroller;

import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Professor;
import com.spring.planner.entities.Unavailability;
import com.spring.planner.service.ProfessorService;
import com.spring.planner.service.UnavailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/apiProf")
public class ProfessorRestController {

    @Autowired
    ProfessorService professorService;

    @Autowired
    UnavailabilityService unavailabilityService;

    /**
     * consult a professor planning thanks to the professor id
     * @param id id of the professor
     * @return the list of unavailabilities of the professor
     */
    @RequestMapping(value = "/professorsplanning/{id}")
    public List<Unavailability> professorPlanningById(@PathVariable("id") Long id){
        return unavailabilityService.findUnavailibilityByProfessorId(id);
    }

    @RequestMapping(value = "/addprofessors", method = RequestMethod.POST)
    public Professor addProfessor(@RequestBody Professor professor){
        return professorService.addProfessor(professor);
    }

    @RequestMapping(value = "/findprofessors/{id}")
    public Professor findProfessorById(@PathVariable("id") Long id){
        return professorService.findProfessorById(id);
    }

    @RequestMapping(value = "/deleteprofessor/{id}")
    public void deleteProfessorById(@PathVariable("id")Long id){
        professorService.deleteProfessorById(id);
    }

    @RequestMapping(value = "/findallprofessors")
    public List<Professor> findAllProfessors(){
        return professorService.findAllProfessors();
    }


}
