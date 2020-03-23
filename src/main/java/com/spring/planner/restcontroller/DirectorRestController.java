package com.spring.planner.restcontroller;

import com.spring.planner.entities.Director;
import com.spring.planner.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class DirectorRestController {

    @Autowired
    DirectorService directorService;

    @RequestMapping(value = "/addDirector")
    public Director addDirector(Director director){
        return directorService.addDirector(director);
    }

    @RequestMapping(value = "/deletedirector/{id}")
    public void deleteDirectorById(@PathVariable("id") Long id){
        directorService.deleteDirectorById(id);
    }
}
