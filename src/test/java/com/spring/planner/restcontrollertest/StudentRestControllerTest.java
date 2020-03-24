package com.spring.planner.restcontrollertest;

import com.spring.planner.entities.*;
import com.spring.planner.restcontroller.StudentRestController;
import com.spring.planner.service.StudentService;
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
public class StudentRestControllerTest {

    @InjectMocks
    StudentRestController studentRestController;

    @Mock
    StudentService studentService;

    @Mock
    UnavailabilityService unavailabilityService;


    @Test
    /**
     * unit test of getAllStudent() from class StudentRestController
     */
    public void getAllStudentByStudentClassTest() {
        StudentClass studentClass = new StudentClass();
        studentClass.setStudentClassId(1L);
        StudentClass studentClass2 = new StudentClass();
        studentClass2.setStudentClassId(2L);
        Student student = new Student("","","","",studentClass);
        Student student1 = new Student("","","","",studentClass2);
        Student student2 = new Student("","","","",studentClass);
        List<Student> studentList = Arrays.asList(student, student2);
        Mockito.when(studentService.getAllStudentByStudentClassId(student.getStudentId())).thenReturn(studentList);
        List<Student> listExpected = studentRestController.getAllStudentsByStudentClassId(student.getStudentId());
        assertEquals(studentList.size(), listExpected.size(), "getAllStudentTest not passed");
    }

    @Test
    /**
     * unit test of addStudent() from class StudentRestController
     */
    public void addStudentTest() {
        Student student = new Student();
        when(studentService.addStudent(any(Student.class))).thenReturn(student);
        Student result = studentRestController.addStudent(student);
        assertEquals(result, student, "addStudentTest RestController not passed");
    }

    @Test
    /**
     * unit test of deleteStudentById() from class StudentRestController
     */
    public void deleteStudentByIdTest() {
        Long idExpected = 3L;
        studentRestController.deletestudentById(idExpected);
        verify(studentService).deleteStudentById(eq(idExpected));
    }

    @Test
    /**
     * unit test of findStudentById() from class StudentRestController
     */
    public void findStudentById() {
        Student student = new Student();
        student.setStudentId(1L);
        Mockito.when(studentService.findStudentById(student.getStudentId())).thenReturn(student);
        Student found = studentRestController.findStudentById(student.getStudentId());
        assertEquals(student, found, "findStudentByIdTest RestController not passed");
        assertEquals(student.getStudentId(), found.getStudentId(), "findStudentByIdTest Rest Controller not passed, ID different");
    }
}
