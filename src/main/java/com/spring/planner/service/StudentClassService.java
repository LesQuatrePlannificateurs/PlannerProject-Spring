package com.spring.planner.service;

import com.spring.planner.entities.StudentClass;
import com.spring.planner.entities.Unavailability;
import com.spring.planner.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentClassService {

    @Autowired
    StudentClassRepository studentClassRepository;


    /**
     * Find a studentClass by its id
     * @param id of the specific studentClass
     * @return a studentClass if it exists, else return null
     */
    public StudentClass findStudentClassById(Long id){
        return studentClassRepository.findById(id).orElse(null);
    }

    /**
     * Add a studentClass
     * @param studentClass to add
     * @return the added studentClass
     */
    public StudentClass addStudentClass(StudentClass studentClass){
        return studentClassRepository.save(studentClass);
    }

    /**
     * Delete a studentCLass thanks to its id
     * @param studentClassId to delete
     */
    public void deleteStudentClass(Long studentClassId){
        studentClassRepository.deleteById(studentClassId);
    }

    /**
     * get all the studentClass
     * @return a List of all studentClass
     */
    public List<StudentClass> getAllStudentCLass(){
        return (List<StudentClass>) studentClassRepository.findAll();
    }

}



