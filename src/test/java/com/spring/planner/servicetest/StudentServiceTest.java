package com.spring.planner.servicetest;



import com.spring.planner.entities.*;
import com.spring.planner.repository.StudentRepository;
import com.spring.planner.service.StudentService;
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
public class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    @Test
    /**
     * unit test of addStudent() from class StudentService
     */
    public void addStudentTest(){
        StudentClass studentClass = new StudentClass();
        Mockito.when(studentRepository.save(any(Student.class))).then(returnsFirstArg());
        Student expectedStudent = new Student("login","psw","firstname","lastname",studentClass);
        Student found = studentService.addStudent(expectedStudent);
        assertEquals(expectedStudent,found,"addStudentTest not passed");
    }

    @Test
    /**
     * unit test of deleteStudentById() from class StudentService
     */
    public void deleteStudentByIdTest(){
        Long idExpected = 3L;
        studentService.deleteStudentById(idExpected);
        verify(studentRepository).deleteById(eq(idExpected));
    }

    @Test
    /**
     * unit test of findStudentById() from class StudentService
     */
    public void findStudentByIdTest(){
        Student student = new Student();
        student.setStudentId(1L);
        Mockito.when(studentRepository.findById(student.getStudentId())).thenReturn(Optional.of(student));
        Student found = studentService.findStudentById(student.getStudentId());
        assertEquals(student,found,"findStudentByIdTest not passed");
        assertEquals(student.getStudentId(),found.getStudentId(),"findStudentByIdTest not passed, ID different");
    }

    @Test
    /**
     * unit test of getAllStudent() from class StudentService
     */
    public void getAllStudentTest(){
        Student student= new Student();
        Student student1 = new Student();
        Iterable<Student>studentIterable= Arrays.asList(student,student1);
        Mockito.when(studentRepository.findAll()).thenReturn(studentIterable);
        List<Student> listExpected=studentService.getAllStudent();
        assertEquals(StreamSupport.stream(studentIterable.spliterator(),false).count(),listExpected.size(),"getAllStudentTest not passed");
    }

    @Test
    public void getAllStudentByStudentClassIdTest(){
        StudentClass studentClass = new StudentClass("name1");
        studentClass.setStudentClassId(1L);
        StudentClass studentClass2 = new StudentClass("name2");
        studentClass2.setStudentClassId(2L);
        Student student = new Student("login1","name indispo1","start 1","end 1",studentClass);
        Student student1 = new Student("login2","name indispo2","start 2","end 2",studentClass2);
        Student student2 = new Student("login3","name indispo3","start 3","end 3",studentClass2);
        Iterable<Student>studentsIterable=Arrays.asList(student1,student2);
        Mockito.when(studentRepository.findAllStudentByStudentClassId(student1.getStudentClass().getStudentClassId())).thenReturn(studentsIterable);
        assertEquals(studentService.getAllStudentByStudentClassId(student1.getStudentClass().getStudentClassId()).size(),2L, "getAllStudentByStudentClassIdTest not passed");
    }
}
