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
    public CommandLineRunner demo(UnavailabilityRepository repository, ProfessorReporitory reporitory1, ClassroomRepository repository2) {
        {
            return new CommandLineRunner() {
                @Override
                public void run(String... args) throws Exception {
                    Professor professor = new Professor("Audenb", "blabla","Aude","NB");
                    reporitory1.save(professor);
                    Classroom classroom = new Classroom("salle visio");
                    repository2.save(classroom);
                    repository.save(new Unavailability("Histoire", "03/18/2020 09:00:00","03/18/2020 12:00:00",professor, classroom,12L,23L));
                    repository.save(new Unavailability("Français", "03/19//2020 14:00:00","03/19/2020 17:00:00",professor,classroom,13L,1L));
                    repository.save(new Unavailability("Maths", "03/20/2020 08:00:00","03/20/2020 12:00:00",professor,classroom,13L,1L));
                    System.out.println("Unavailabilities added");
                }
            };
        }


    }

//    @Bean
//    public CommandLineRunner profdemo(ProfessorReporitory repository) {
//        {
//            return new CommandLineRunner() {
//                @Override
//                public void run(String... args) throws Exception {
//                    Professor professor = new Professor("Audenb", "blabla", "Aude", "NB");
//                    repository.save(professor);
//                    System.out.println("Professor added");
//                }
//            };
//        }
//    }


//
//
//    }
//    @Bean
//    public CommandLineRunner demo3(ClassroomRepository repository1) {
//        {
//            return new CommandLineRunner() {
//                @Override
//                public void run(String... args) throws Exception {
//                    Classroom classroom = new Classroom("salle visio");
//                    repository1.save(classroom);
//                    System.out.println("Classroom added");
//                }
//            };
//        }
//
//
//    }

}
