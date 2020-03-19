package com.spring.planner;

import com.spring.planner.entities.Professor;
import com.spring.planner.entities.Unavailability;
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
                    repository.save(new Unavailability("histoire", "14h00","15h00",2L, 3L,12L,23L));
                    repository.save(new Unavailability("math", "08h00","10h00",4L,6L,13L,1L));
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

}
