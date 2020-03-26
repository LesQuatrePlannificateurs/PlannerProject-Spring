package com.spring.planner.restcontrollertest;


import com.spring.planner.entities.*;
import com.spring.planner.restcontroller.ProfessorRestController;
import com.spring.planner.service.ProfessorService;
import com.spring.planner.service.UnavailabilityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProfessorRestControllerTest {

    @InjectMocks
    ProfessorRestController professorRestController;

    @Mock
    ProfessorService professorService;

    @Mock
    UnavailabilityService unavailabilityService;

    @Test
    /**
     * unit test of addProfessor() from class ProfessorRestController
     */
    public void addProfessorTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Professor professor = new Professor("login","psw","firstname","lastname");
        when(professorService.addProfessor(any(Professor.class))).thenReturn(professor);
        Professor result = professorRestController.addProfessor(professor);
        assertEquals(result,professor,"addProfessorTest RestController not passed");
    }

    @Test
    /**
     * unit test of findProfessorById() from class ProfessorRestController
     */
    public void findProfessorByIdTest(){
        Professor professor = new Professor("login", "password","firstname","lastname");
        professor.setProfessorId(1L);
        Mockito.when(professorService.findProfessorById(professor.getProfessorId())).thenReturn(professor);
        Professor found = professorRestController.findProfessorById(professor.getProfessorId());
        assertEquals(professor,found,"findProfessorByIdTest RestController not passed");
        assertEquals(professor.getProfessorId(),found.getProfessorId(),"findProfessorByIdTest Rest Controller not passed, ID different");
    }

    @Test
    /**
     * unit test of deleteProfessorById() from class ProfessorRestController
     */
    public void deleteProfessorByIdTest(){
        Long idExpected = 3L;
        professorRestController.deleteProfessorById(idExpected);
        verify(professorService).deleteProfessorById(eq(idExpected));
    }

    @Test
    public void professorPlanningByIdTest(){
        Professor professor = new Professor("login1","psw1","firstname1","lastname1");
        professor.setProfessorId(1L);
        Professor professor2 = new Professor("login2","psw2","firstname2","lastname2");
        professor2.setProfessorId(2L);
        Equipment equipment = new Equipment();
        professor.setProfessorId(1L);
        Classroom classroom = new Classroom();
        professor.setProfessorId(1L);
        StudentClass studentClass = new StudentClass();
        studentClass.setStudentClassId(1L);
        Unavailability unavailability = new Unavailability("name indispo1","start 1","end 1", professor, classroom,studentClass,equipment);
        Unavailability unavailability1 = new Unavailability("name indispo2","start 2","end 2",professor2,classroom,studentClass,equipment);
        Unavailability unavailability2 = new Unavailability("name indispo3","start 3","end 3",professor,classroom,studentClass,equipment);
        List<Unavailability> unavailabilities= Arrays.asList(unavailability,unavailability2);
        Mockito.when(unavailabilityService.findUnavailibilityByProfessorId(unavailability.getProfessor().getProfessorId())).thenReturn(unavailabilities);
        assertEquals(professorRestController.professorPlanningById(unavailability.getProfessor().getProfessorId()).size(),2L,"getPlanningProfessorTest RestController not passed");
    }

    @Test
    public void getAllProfessorsTest(){
        Professor professor= new Professor();
        Professor professor1 = new Professor();
        List<Professor> professorList= Arrays.asList(professor,professor1);
        Mockito.when(professorService.findAllProfessors()).thenReturn(professorList);
        List<Professor> listExpected=professorRestController.findAllProfessors();
        assertEquals(professorList.size(),listExpected.size(),"getAllProfessorTest not passed");
    }
}
