package com.spring.planner.restcontroller;

import com.spring.planner.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RoomRestController {
    @Autowired
    ClassroomService classroomService;

    @GetMapping("/classroomPlanning")
    public String getPlanningClassroom(@RequestParam(name="id")Long id, Model model){
        List unaList = classroomService.fetchClassroomUnavailibility(id) ;

        model.addAttribute("weekPlanning", unaList);
        return "classroom-planning-week";
    }
}
