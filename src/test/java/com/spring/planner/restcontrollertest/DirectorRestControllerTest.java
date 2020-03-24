package com.spring.planner.restcontrollertest;

import com.spring.planner.entities.Director;
import com.spring.planner.restcontroller.DirectorRestController;
import com.spring.planner.service.DirectorService;
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
public class DirectorRestControllerTest {

    @InjectMocks
    DirectorRestController directorRestController;

    @Mock
    DirectorService directorService;

    @Test
    /**
     * unit test of addDirector() from class DirectorRestController
     */
    public void addDirectorTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Director director = new Director("login","psw","firstname","lastname");
        when(directorService.addDirector(any(Director.class))).thenReturn(director);
        Director result = directorRestController.addDirector(director);
        assertEquals(result,director,"addDirectorTest RestController not passed");
    }

    @Test
    /**
     * unit test of findDirectorById() from class DirectorRestController
     */
    public void findDirectorByIdTest(){
        Director director = new Director("login", "password","firstname","lastname");
        director.setDirectorId(1L);
        Mockito.when(directorService.findDirectorById(director.getDirectorId())).thenReturn(director);
        Director found = directorRestController.findDirectorById(director.getDirectorId());
        assertEquals(director,found,"findDirectorByIdTest RestController not passed");
        assertEquals(director.getDirectorId(),found.getDirectorId(),"findDirectorByIdTest Rest Controller not passed, ID different");
    }

    @Test
    /**
     * unit test of deleteDirectorById() from class DirectorRestController
     */
    public void deleteDirectorByIdTest(){
        Long idExpected = 3L;
        directorRestController.deleteDirectorById(idExpected);
        verify(directorService).deleteDirectorById(eq(idExpected));
    }

    @Test
    public void findAllDirectorsTest(){
        Director director= new Director();
        Director director1 = new Director();
        List<Director> directorList= Arrays.asList(director,director1);
        Mockito.when(directorService.findAllDirectors()).thenReturn(directorList);
        List<Director> listExpected=directorRestController.findAllDirectors();
        assertEquals(directorList.size(),listExpected.size(),"getAllDirectorTest not passed");
    }
}
