package com.spring.planner.service;

import com.spring.planner.entities.Professor;
import com.spring.planner.repository.ProfessorReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    ProfessorReporitory professorRepository;

    /**
     * Add a Professor
     * @param professor is the new professor to add
     * @return the new professor added
     */
    public Professor addProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    /**
     * find a professor by his id
     * @param id id of the professor to find
     * @return return the found professor
     */
    public Professor findProfessorById(Long id){
        return professorRepository.findById(id).orElse(null);
    }

    public void deleteProfessorById(Long id){
        professorRepository.deleteById(id);
    }

    public List<Professor> findAllProfessors(){
        return (List<Professor>) professorRepository.findAll();
    }
}
