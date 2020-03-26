package com.spring.planner.servicetest;

import com.spring.planner.entities.Professor;
import com.spring.planner.entities.StudentClass;
import com.spring.planner.repository.ProfessorReporitory;
import com.spring.planner.repository.StudentClassRepository;
import com.spring.planner.service.ProfessorService;
import com.spring.planner.service.StudentClassService;
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
public class StudentClassTest {

    @InjectMocks
    StudentClassService studentClassService;

    @Mock
    StudentClassRepository studentClassRepository;

    @Test
    /**
     * unit test of addStudentClass() from class StudentClassService
     */
    public void addStudentClassTest(){
        Mockito.when(studentClassRepository.save(any(StudentClass.class))).then(returnsFirstArg());
        StudentClass expectedStudentClass = new StudentClass("name");
        StudentClass found = studentClassService.addStudentClass(expectedStudentClass);
        assertEquals(expectedStudentClass,found,"addStudentClassTest not passed");
    }

    @Test
    /**
     * unit test of deleteProfessorById() from class ProfessorService
     */
    public void deleteStudentClassByIdTest(){
        Long idExpected = 3L;
        studentClassService.deleteStudentClass(idExpected);
        verify(studentClassRepository).deleteById(eq(idExpected));
    }

    @Test
    /**
     * unit test of findProfessorById() from class ProfessorService
     */
    public void findStudentClassByIdTest(){
        StudentClass studentClass = new StudentClass("name");
        studentClass.setStudentClassId(1L);
        Mockito.when(studentClassRepository.findById(studentClass.getStudentClassId())).thenReturn(Optional.of(studentClass));
        StudentClass found = studentClassService.findStudentClassById(studentClass.getStudentClassId());
        assertEquals(studentClass,found,"findStudentClassByIdTest not passed");
        assertEquals(studentClass.getStudentClassId(),found.getStudentClassId(),"findStudentClassByIdTest not passed, ID different");
    }

    @Test
    /**
     * unit test of getProfessor() from class ProfessorService
     */
    public void getAllStudentClassTest(){
        StudentClass studentClass= new StudentClass();
        StudentClass studentClass1 = new StudentClass();
        Iterable<StudentClass>studentClassesIterable= Arrays.asList(studentClass,studentClass1);
        Mockito.when(studentClassRepository.findAll()).thenReturn(studentClassesIterable);
        List<StudentClass> listExpected=studentClassService.getAllStudentCLass();
        assertEquals(StreamSupport.stream(studentClassesIterable.spliterator(),false).count(),listExpected.size(),"getAllStudentClassTest not passed");
    }
}
