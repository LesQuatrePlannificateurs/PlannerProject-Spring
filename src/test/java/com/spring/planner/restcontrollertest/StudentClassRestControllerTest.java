package com.spring.planner.restcontrollertest;

import com.spring.planner.entities.*;
import com.spring.planner.entities.StudentClass;
import com.spring.planner.entities.StudentClass;
import com.spring.planner.restcontroller.RoomRestController;
import com.spring.planner.restcontroller.StudentClassRestController;
import com.spring.planner.service.StudentClassService;
import com.spring.planner.service.UnavailabilityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentClassRestControllerTest {

    @InjectMocks
    StudentClassRestController studentClassRestController;

    @Mock
    StudentClassService studentClassService;

    @Mock
    UnavailabilityService unavailabilityService;


    @Test
    /**
     * unit test of getAllStudentClass() from class StudentClassRestController
     */
    public void getAllStudentClassTest(){
        StudentClass studentClass= new StudentClass();
        StudentClass studentClass1 = new StudentClass();
        List<StudentClass> studentClassList= Arrays.asList(studentClass,studentClass1);
        Mockito.when(studentClassService.getAllStudentCLass()).thenReturn(studentClassList);
        List<StudentClass> listExpected=studentClassRestController.getAllStudentClass();
        assertEquals(studentClassList.size(),listExpected.size(),"getAllStudentClassTest not passed");
    }

    @Test
    /**
     * unit test of addStudentClass() from class StudentClassRestController
     */
    public void addStudentClassTest(){
        StudentClass studentClass = new StudentClass("name");
        when(studentClassService.addStudentClass(any(StudentClass.class))).thenReturn(studentClass);
        StudentClass result = studentClassRestController.addStudentClass(studentClass);
        assertEquals(result,studentClass,"addStudentClassTest RestController not passed");
    }

    @Test
    /**
     * unit test of deleteStudentClassById() from class StudentClassRestController
     */
    public void deleteStudentClassByIdTest(){
        Long idExpected = 3L;
        studentClassRestController.deleteStudentClass(idExpected);
        verify(studentClassService).deleteStudentClass(eq(idExpected));
    }

    @Test
    /**
     * unit test of findStudentClassById() from class StudentClassRestController
     */
    public void findStudentClassById(){
        StudentClass studentClass = new StudentClass("name");
        studentClass.setStudentClassId(1L);
        Mockito.when(studentClassService.findStudentClassById(studentClass.getStudentClassId())).thenReturn(studentClass);
        StudentClass found = studentClassRestController.findStudentClassById(studentClass.getStudentClassId());
        assertEquals(studentClass,found,"findStudentClassByIdTest RestController not passed");
        assertEquals(studentClass.getStudentClassId(),found.getStudentClassId(),"findStudentClassByIdTest Rest Controller not passed, ID different");
    }

    @Test
    /**
     * unit test of getPlanningStudentClass() from class StudentClassRestController
     */
    public void getPlanningStudentClassTest(){
        Equipment equipment = new Equipment("6ème");
        equipment.setEquipmentId(1L);
        Professor professor = new Professor("login","psw","firstname","lastname");
        professor.setProfessorId(1L);
        Classroom classroom = new Classroom();
        equipment.setEquipmentId(1L);
        StudentClass studentClass = new StudentClass("name1");
        studentClass.setStudentClassId(1L);
        StudentClass studentClass2 = new StudentClass("name2");
        studentClass2.setStudentClassId(2L);
        Unavailability unavailability = new Unavailability("name indispo1","start 1","end 1", professor, classroom,studentClass,equipment);
        Unavailability unavailability1 = new Unavailability("name indispo2","start 2","end 2",professor,classroom,studentClass2,equipment);
        Unavailability unavailability2 = new Unavailability("name indispo3","start 3","end 3",professor,classroom,studentClass,equipment);
        List<Unavailability> unavailabilities= Arrays.asList(unavailability,unavailability2);
        Mockito.when(unavailabilityService.findUnavailibilityByStudentClassId(unavailability.getStudentClass().getStudentClassId())).thenReturn(unavailabilities);
        assertEquals(studentClassRestController.getPlanningStudentClass(unavailability.getStudentClass().getStudentClassId()).size(),2L,"getPlanningStudentClassTest RestController not passed");
    }
}
