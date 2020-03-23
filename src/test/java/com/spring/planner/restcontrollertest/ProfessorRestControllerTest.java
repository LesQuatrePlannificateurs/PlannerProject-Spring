package com.spring.planner.restcontrollertest;


import com.spring.planner.entities.Professor;
import com.spring.planner.restcontroller.ProfessorRestController;
import com.spring.planner.service.ProfessorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
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
}
