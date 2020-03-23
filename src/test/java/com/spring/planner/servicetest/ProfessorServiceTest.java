package com.spring.planner.servicetest;

import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Professor;
import com.spring.planner.repository.ClassroomRepository;
import com.spring.planner.repository.ProfessorReporitory;
import com.spring.planner.service.ClassroomService;
import com.spring.planner.service.ProfessorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProfessorServiceTest {

    @InjectMocks
    ProfessorService professorService;

    @Mock
    ProfessorReporitory professorReporitory;



    @Test
    /**
     * unit test of addProfessor() from class ProfessorService
     */
    public void addProfessorTest(){
        Mockito.when(professorReporitory.save(any(Professor.class))).then(returnsFirstArg());
        Professor expectedProfessor = new Professor("login", "password","firstname","lastname");
        Professor found = professorService.addProfessor(expectedProfessor);
        assertEquals(expectedProfessor,found,"addProfessorTest not passed");
    }

    @Test
    /**
     * unit test of deleteProfessorById() from class ProfessorService
     */
    public void deleteProfessorByIdTest(){
        Long idExpected = 3L;
        professorService.deleteProfessorById(idExpected);
        verify(professorReporitory).deleteById(eq(idExpected));
    }

    @Test
    /**
     * unit test of findProfessorById() from class ProfessorService
     */
    public void findProfessorByIdTest(){
        Professor professor = new Professor("login", "password","firstname","lastname");
        professor.setProfessorId(1L);
        Mockito.when(professorReporitory.findById(professor.getProfessorId())).thenReturn(Optional.of(professor));
        Professor found = professorService.findProfessorById(professor.getProfessorId());
        assertEquals(professor,found,"findProfessorByIdTest not passed");
        assertEquals(professor.getProfessorId(),found.getProfessorId(),"findProfessorByIdTest not passed, ID different");

    }
}
