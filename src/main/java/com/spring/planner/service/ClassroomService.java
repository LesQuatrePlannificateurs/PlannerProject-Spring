package com.spring.planner.service;

import com.spring.planner.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;

public List fetchClassroomUnavailibility(Long id){
    return (List) classroomRepository.findUnavailabilityByClassroomId(id);
}
}
