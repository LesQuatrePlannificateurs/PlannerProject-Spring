package com.spring.planner;

import com.spring.planner.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {


        @Autowired
    ClassroomService classroomService;

        @Override
        public void run(String... args) throws Exception {
            System.out.println("executing my command");
        }
}
