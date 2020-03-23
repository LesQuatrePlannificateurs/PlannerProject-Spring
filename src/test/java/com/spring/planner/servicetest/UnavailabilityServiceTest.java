package com.spring.planner.servicetest;


import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Professor;
import com.spring.planner.entities.Unavailability;
import com.spring.planner.repository.UnavailabilityRepository;
import com.spring.planner.service.UnavailabilityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UnavailabilityServiceTest {

    @InjectMocks
    UnavailabilityService unavailabilityService;

    @Mock
    UnavailabilityRepository unavailabilityRepository;


    @Test
    /**
     * unit test of addUnavailability() from class UnavailabilityService
     */
    public void addUnavailabilityTest(){
        Mockito.when(unavailabilityRepository.save(any(Unavailability.class))).then(returnsFirstArg());
        Unavailability unavailability = new Unavailability();
        Unavailability found = unavailabilityService.addUnavailability(unavailability);
        assertEquals(found,unavailability,"addUnaivailabilityTest not passed");
    }

    @Test
    /**
     * unit test of findUnavailabilityByClassroomId() from class UnavailabilityService
     */
    public void findUnavailibilityByClassroomIdTest(){
        Classroom classroom = new Classroom("6ème");
        classroom.setId(1L);
        Classroom classroom2 = new Classroom("5ème");
        classroom2.setId(2L);
        Professor professor = new Professor(" "," "," "," ");
        professor.setProfessorId(1L);
        Unavailability unavailability = new Unavailability("name indispo1","start 1","end 1", professor, classroom,2L,2L);
        Unavailability unavailability1 = new Unavailability("name indispo2","start 2","end 2",professor,classroom2,2L,2L);
        Unavailability unavailability2 = new Unavailability("name indispo3","start 3","end 3",professor,classroom,2L,2L);
        Iterable<Unavailability>unavailabilityIterable=Arrays.asList(unavailability,unavailability2);
        Mockito.when(unavailabilityRepository.findUnavailabilityByClassroomId(unavailability.getClassroom().getId())).thenReturn(unavailabilityIterable);
        assertEquals(unavailabilityService.findUnavailibilityByClassroomId(unavailability.getClassroom().getId()).size(),2L,"findUnavailibilityByClassroomIdTes not passed");

    }

    @Test
    /**
     * unit test of findUnavailabilityByProfessorId() from class UnavailabilityService
     */
    public void findUnavailibilityByProfessorIdTest(){
        Professor professor = new Professor(" "," "," "," ");
        professor.setProfessorId(1L);
        Professor professor2 = new Professor(" "," "," "," ");
        professor2.setProfessorId(2L);
        Classroom classroom = new Classroom();
        Unavailability unavailability = new Unavailability("name indispo1","start 1","end 1",professor,classroom,2L,2L);
        Unavailability unavailability1 = new Unavailability("name indispo2","start 2","end 2",professor2,classroom,2L,2L);
        Unavailability unavailability2 = new Unavailability("name indispo3","start 3","end 3",professor2,classroom,2L,2L);
        Iterable<Unavailability>unavailabilityIterable=Arrays.asList(unavailability1,unavailability2);
        Mockito.when(unavailabilityRepository.findUnavailabilityByProfessorId(unavailability1.getProfessor().getProfessorId())).thenReturn(unavailabilityIterable);
        assertEquals(unavailabilityService.findUnavailibilityByProfessorId(unavailability1.getProfessor().getProfessorId()).size(),2L, "findUnavailibilityByProfessorIdTest not passed");
    }

    @Test
    /**
     * unit test of deleteUnavailabilityById() from class UnavailabilityService
     */
    public void deleteUnavailabilityByIdTest() {
        Long idExpected = 3L;
        unavailabilityService.deleteUnavailabilityById(idExpected);
        verify(unavailabilityRepository).deleteById(eq(idExpected));
    }

    @Test
    /**
     * unit test of findUnavailabilityById() from class UnavailabilityService
     */
    public void findUnavailabilityByIdTest(){
        Professor professor = new Professor();
        Classroom classroom = new Classroom();
        Unavailability unavailability = new Unavailability("name indispo","start","end",professor,classroom,1L,1L);
        unavailability.setId(1L);
        Mockito.when(unavailabilityRepository.findById(unavailability.getId())).thenReturn(Optional.of(unavailability));
        Unavailability found = unavailabilityService.findUnavailabilityById(unavailability.getId());
        assertEquals(unavailability.getId(),found.getId());
        assertEquals(unavailability,found,"findUnavailabilityByIdTest not passed");
    }

    @Test
    /**
     * unit test of updateUnavailability() from class UnavailabilityService
     */
    public void updateUnavailabilityTest(){
        Professor professor = new Professor("1","1","1","1");
        professor.setProfessorId(1L);
        Professor professor2 = new Professor("2","2","2","2");
        professor2.setProfessorId(2L);
        Classroom classroom = new Classroom("6ème");
        classroom.setId(1L);
        Classroom classroom2 = new Classroom("5ème");
        classroom2.setId(2L);
        Unavailability unavailabilityToUpdate= new Unavailability("name indispo","start","end",professor,classroom,1L,1L);
        unavailabilityToUpdate.setId(1L);
        Unavailability expected = new Unavailability("name indispo2","start2","end2",professor2,classroom2,2L,2L);
        expected.setId(1L);
        Mockito.when(unavailabilityRepository.findById(unavailabilityToUpdate.getId())).thenReturn(Optional.of(unavailabilityToUpdate));
        Mockito.when(unavailabilityRepository.save(unavailabilityToUpdate)).thenReturn(unavailabilityToUpdate);
        Unavailability unavailabilityUpdated = unavailabilityService.updateUnavailability(expected, unavailabilityToUpdate.getId());
        assertEquals(unavailabilityUpdated.getId(),expected.getId());
        assertEquals(unavailabilityUpdated.getClassroom().getId(),expected.getClassroom().getId());
        assertEquals(unavailabilityUpdated.getProfessor().getProfessorId(),expected.getProfessor().getProfessorId());
        assertEquals(unavailabilityUpdated.getEquipmentId(),expected.getEquipmentId());
        assertEquals(unavailabilityUpdated.getStart(),expected.getStart());
        assertEquals(unavailabilityUpdated.getNameIndispo(),expected.getNameIndispo());
        assertEquals(unavailabilityUpdated.getStart(),expected.getStart());
        assertEquals(unavailabilityUpdated.getEnd(),expected.getEnd(),"updateUnavailabilityTest not passed");
    }
}
