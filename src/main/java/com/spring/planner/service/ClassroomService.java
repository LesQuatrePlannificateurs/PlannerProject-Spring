package com.spring.planner.service;

import com.spring.planner.entities.Classroom;
import com.spring.planner.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;


    /**
     * Find a classroom by its id
     * @param id of the specific classroom
     * @return a classroom if it exists, else return null
     */
    public Classroom findClassroombyId(Long id){
        return classroomRepository.findById(id).orElse(null);
    }

    /**
     * Add a classroom
     * @param classroom to add
     * @return the added classroom
     */
    public Classroom addClassroom(Classroom classroom){
        return classroomRepository.save(classroom);
    }

    /**
     * Delete a classroom thanks to its id
     * @param classroomId to delete
     */
    public void deleteClassroom(Long classroomId){
        Classroom classroom = this.findClassroombyId(classroomId);
        classroomRepository.delete(classroom);
    }

    /**
     * get all the classrooms
     * @return a List of all classrooms
     */
    public List<Classroom> getAllClassroom(){
        return (List<Classroom>) classroomRepository.findAll();
    }

}
