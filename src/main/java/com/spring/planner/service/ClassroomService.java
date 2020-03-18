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

    public Classroom findClassroombyId(Long id){
        return classroomRepository.findById(id).orElse(null);
    }

    public Classroom addClassroom(Classroom classroom){
        return classroomRepository.save(classroom);
    }

    public void deleteClassroom(Long classroomId){
        Classroom classroom = this.findClassroombyId(classroomId);
        classroomRepository.delete(classroom);
    }

    public List<Classroom> getAllClassroom(){
        return (List<Classroom>) classroomRepository.findAll();
    }

}
