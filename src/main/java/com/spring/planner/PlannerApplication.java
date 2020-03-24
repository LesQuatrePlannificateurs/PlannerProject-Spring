package com.spring.planner;

import com.spring.planner.entities.*;
import com.spring.planner.repository.*;
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
    public CommandLineRunner demo(UnavailabilityRepository urepository, ProfessorReporitory pRreporitory, ClassroomRepository clrepository, StudentClassRepository strepository, EquipmentRepository equipmentRepository) {
        {
            return new CommandLineRunner() {
                @Override
                public void run(String... args) throws Exception {
                    Professor professor = new Professor("Audenb", "blabla","Aude","NB");
                    pRreporitory.save(professor);
                    Equipment equipment = new Equipment("video projecteur");
                    equipmentRepository.save(equipment);
                    Classroom classroom = new Classroom("salle visio");
                    clrepository.save(classroom);
                    StudentClass stClass = new StudentClass("5èmeB");
                    strepository.save(stClass);
                    urepository.save(new Unavailability("Histoire", "03/23/2020 09:00:00","03/23/2020 12:00:00",professor, classroom,stClass,equipment));
                    urepository.save(new Unavailability("Français", "03/24/2020 14:00:00","03/24/2020 17:00:00",professor,classroom,stClass,equipment));
                    urepository.save(new Unavailability("Maths", "03/25/2020 08:00:00","03/25/2020 12:00:00",professor,classroom,stClass,equipment));
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
