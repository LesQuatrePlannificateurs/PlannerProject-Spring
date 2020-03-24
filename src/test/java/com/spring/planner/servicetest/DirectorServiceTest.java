package com.spring.planner.servicetest;

import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Director;
import com.spring.planner.repository.DirectorRepository;
import com.spring.planner.service.DirectorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DirectorServiceTest {

    @InjectMocks
    DirectorService directorService;

    @Mock
    DirectorRepository directorRepository;

    @Test
    public void addDirectorTest(){
        Mockito.when(directorRepository.save(any(Director.class))).then(returnsFirstArg());
        Director expectedDirector = new Director("login","psw","firstname","lastname");
        expectedDirector.setDirectorId(1L);
        Director found = directorService.addDirector(expectedDirector);
        assertEquals(expectedDirector,found,"addDirectorTest not passed");
    }

    @Test
    public void deleteDirectorByIdTest(){
        Long idExpected = 3L;
        directorService.deleteDirectorById(idExpected);
        verify(directorRepository).deleteById(eq(idExpected));
    }

    @Test
    public void findAllDirectorsTest(){
        Director director= new Director();
        Director director1 = new Director();
        Iterable<Director>directorsIterable= Arrays.asList(director,director1);
        Mockito.when(directorRepository.findAll()).thenReturn(directorsIterable);
        List<Director> listExpected=directorService.findAllDirectors();
        assertEquals(StreamSupport.stream(directorsIterable.spliterator(),false).count(),listExpected.size(),"getAllDirectorTest not passed");
    }

    @Test
    public void findDirectorByIdTest(){
        Director director = new Director();
        director.setDirectorId(1L);
        Mockito.when(directorRepository.findById(director.getDirectorId())).thenReturn(Optional.of(director));
        Director found = directorService.findDirectorById(director.getDirectorId());
        assertEquals(director,found,"findDirectorByIdTest not passed");
    }

}
