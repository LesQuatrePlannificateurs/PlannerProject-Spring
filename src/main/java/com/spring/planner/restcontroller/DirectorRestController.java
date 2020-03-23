package com.spring.planner.restcontroller;

import com.spring.planner.entities.Director;
import com.spring.planner.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api")
public class DirectorRestController {

    @Autowired
    DirectorService directorService;

    @RequestMapping(value = "/adddirector", method = RequestMethod.POST)
    public Director addDirector(@RequestBody Director director){
        return directorService.addDirector(director);
    }

    @RequestMapping(value = "/deletedirector/{id}")
    public void deleteDirectorById(@PathVariable("id") Long id){
        directorService.deleteDirectorById(id);
    }

    @RequestMapping(value = "findalldirectors")
    public List<Director> findAllDirectors(){
        return directorService.findAllDirectors();
    }

    @RequestMapping(value = "/finddirectorbyId/{id}")
    public Director findDirectorById(@PathVariable("id") Long id){
        return directorService.findDirectorById(id);
    }
}
