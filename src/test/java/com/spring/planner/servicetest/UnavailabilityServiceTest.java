package com.spring.planner.servicetest;


import com.spring.planner.entities.*;
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
        Classroom classroom = new Classroom();
        classroom.setClassroomId(1L);
        Classroom classroom2 = new Classroom();
        classroom2.setClassroomId(2L);
        Professor professor = new Professor();
        professor.setProfessorId(1L);
        Equipment equipment = new Equipment();
        StudentClass studentClass = new StudentClass();
        Unavailability unavailability = new Unavailability("name indispo1","start 1","end 1", professor, classroom,studentClass,equipment);
        Unavailability unavailability1 = new Unavailability("name indispo2","start 2","end 2",professor,classroom2,studentClass,equipment);
        Unavailability unavailability2 = new Unavailability("name indispo3","start 3","end 3",professor,classroom,studentClass,equipment);
        Iterable<Unavailability>unavailabilityIterable=Arrays.asList(unavailability,unavailability2);
        Mockito.when(unavailabilityRepository.findUnavailabilityByClassroomId(unavailability.getClassroom().getClassroomId())).thenReturn(unavailabilityIterable);
        assertEquals(unavailabilityService.findUnavailibilityByClassroomId(unavailability.getClassroom().getClassroomId()).size(),2L,"findUnavailibilityByClassroomIdTes not passed");

    }

    @Test
    /**
     * unit test of findUnavailabilityByProfessorId() from class UnavailabilityService
     */
    public void findUnavailibilityByProfessorIdTest(){
        Professor professor = new Professor();
        professor.setProfessorId(1L);
        Professor professor2 = new Professor();
        professor2.setProfessorId(2L);
        Classroom classroom = new Classroom();
        Equipment equipment = new Equipment();
        StudentClass studentClass = new StudentClass();
        Unavailability unavailability = new Unavailability("name indispo1","start 1","end 1",professor,classroom,studentClass,equipment);
        Unavailability unavailability1 = new Unavailability("name indispo2","start 2","end 2",professor2,classroom,studentClass,equipment);
        Unavailability unavailability2 = new Unavailability("name indispo3","start 3","end 3",professor2,classroom,studentClass,equipment);
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
        Equipment equipment = new Equipment();
        StudentClass studentClass = new StudentClass();
        Unavailability unavailability = new Unavailability("name indispo","start","end",professor,classroom,studentClass,equipment);
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
        classroom.setClassroomId(1L);
        Classroom classroom2 = new Classroom("5ème");
        classroom2.setClassroomId(2L);
        Equipment equipment = new Equipment("equipment name1");
        equipment.setEquipmentId(1L);
        StudentClass studentClass = new StudentClass("student name1");
        studentClass.setStudentClassId(1L);
        Equipment equipment2 = new Equipment("equipment name2");
        equipment2.setEquipmentId(2L);
        StudentClass studentClass2 = new StudentClass("student name2");
        studentClass2.setStudentClassId(2L);
        Unavailability unavailabilityToUpdate= new Unavailability("name indispo","start","end",professor,classroom,studentClass,equipment);
        unavailabilityToUpdate.setId(1L);
        Unavailability expected = new Unavailability("name indispo2","start2","end2",professor2,classroom2,studentClass2,equipment2);
        expected.setId(1L);
        Mockito.when(unavailabilityRepository.findById(unavailabilityToUpdate.getId())).thenReturn(Optional.of(unavailabilityToUpdate));
        Mockito.when(unavailabilityRepository.save(unavailabilityToUpdate)).thenReturn(unavailabilityToUpdate);
        Unavailability unavailabilityUpdated = unavailabilityService.updateUnavailability(expected, unavailabilityToUpdate.getId());
        assertEquals(unavailabilityUpdated.getId(),expected.getId());
        assertEquals(unavailabilityUpdated.getClassroom(),expected.getClassroom());
        assertEquals(unavailabilityUpdated.getProfessor(),expected.getProfessor());
        assertEquals(unavailabilityUpdated.getEquipment(),expected.getEquipment());
        assertEquals(unavailabilityUpdated.getStart(),expected.getStart());
        assertEquals(unavailabilityUpdated.getNameIndispo(),expected.getNameIndispo());
        assertEquals(unavailabilityUpdated.getStudentClass(),expected.getStudentClass());
        assertEquals(unavailabilityUpdated.getEnd(),expected.getEnd(),"updateUnavailabilityTest not passed");
    }
}
