package com.spring.planner;

import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Professor;
import com.spring.planner.entities.Unavailability;
import com.spring.planner.repository.ClassroomRepository;
import com.spring.planner.repository.ProfessorReporitory;
import com.spring.planner.repository.UnavailabilityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlannerApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(UnavailabilityRepository repository) {
        {
            return new CommandLineRunner() {
                @Override
                public void run(String... args) throws Exception {
                    repository.save(new Unavailability("histoire", "11/03/2020 14:00:00","11/03/2020 15:00:00",2L, 1L,12L,23L));
                    repository.save(new Unavailability("histoire", "10/03/2020 14:00:00","10/03/2020 15:00:00",4L,1L,13L,1L));
                    repository.save(new Unavailability("math", "13/03/2020 10:00:00","13/03/2020 12:00:00",4L,1L,13L,1L));
                    System.out.println("Unavailabilities added");
                }
            };
        }


    }

    @Bean
    public CommandLineRunner profdemo(ProfessorReporitory repository) {
        {
            return new CommandLineRunner() {
                @Override
                public void run(String... args) throws Exception {
                    repository.save(new Professor("Audenb", "blabla","Aude","NB"));
                    System.out.println("Professor added");
                }
            };
        }


    }
    @Bean
    public CommandLineRunner demo3(ClassroomRepository repository1) {
        {
            return new CommandLineRunner() {
                @Override
                public void run(String... args) throws Exception {
                    repository1.save(new Classroom("salle visio"));
                    System.out.println("Classroom added");
                }
            };
        }


    }

}
