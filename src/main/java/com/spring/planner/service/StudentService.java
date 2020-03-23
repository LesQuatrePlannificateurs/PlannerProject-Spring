package com.spring.planner.service;

import com.spring.planner.entities.Student;
import com.spring.planner.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    /**
     * Find a student by its id
     * @param id of the specific student
     * @return a student if it exists, else return null
     */
    public Student findStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    /**
     * Add a student
     * @param student to add
     * @return the added student
     */
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    /**
     * Delete a studentCLass thanks to its id
     * @param studentId to delete
     */
    public void deleteStudentById(Long studentId){
        studentRepository.deleteById(studentId);
    }

    /**
     * get all the student
     * @return a List of all student
     */
    public List<Student> getAllStudent(){
        return (List<Student>) studentRepository.findAll();
    }

    public List<Student> getAllStudentByStudentClassId(Long studentClassId){
        return (List<Student>) studentRepository.findAllStudentByStudentClassId(studentClassId);
    }


}
