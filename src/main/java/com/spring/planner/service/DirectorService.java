package com.spring.planner.service;

import com.spring.planner.entities.Director;
import com.spring.planner.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    @Autowired
    DirectorRepository directorRepository;

    public Director addDirector(Director director){
        return directorRepository.save(director);
    }

    public void deleteDirectorById(Long id){
        directorRepository.deleteById(id);
    }

    public List<Director> findAllDirectors(){
       return (List<Director>) directorRepository.findAll();
    }

}
