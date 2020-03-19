package com.spring.planner.service;

import com.spring.planner.entities.Professor;
import com.spring.planner.repository.ProfessorReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    ProfessorReporitory professorRepository;

    public Professor addProfessor(Professor professor){
        return professorRepository.save(professor);
    }
}
