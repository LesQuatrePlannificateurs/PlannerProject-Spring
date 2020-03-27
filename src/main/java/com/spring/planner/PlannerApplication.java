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
    public CommandLineRunner demo(UnavailabilityRepository urepository, ProfessorReporitory pRreporitory, ClassroomRepository clrepository,
                                  StudentClassRepository strepository, EquipmentRepository equipmentRepository, StudentRepository stRepo) {
        {
            return new CommandLineRunner() {
                @Override
                public void run(String... args) throws Exception {

                    Professor pA = new Professor("Audenb", "blabla","Aude","NB");
                    Professor pM = new Professor("MathPo", "blo","Math","Port");
                    Professor pAk = new Professor("AkimAl", "bleh","Akim","Ali");
                    Professor pV = new Professor("VicLo", "blou","Vict","Lou");
                    pRreporitory.save(pA);
                    pRreporitory.save(pM);
                    pRreporitory.save(pAk);
                    pRreporitory.save(pV);
                    Equipment e1 = new Equipment("video projecteur");
                    Equipment e2 = new Equipment("peinture");
                    Equipment e3 = new Equipment("mapmonde");
                    Equipment e4 = new Equipment("ordinateur");
                    Equipment e5 = new Equipment("ballon");
                    Equipment e6 = new Equipment("flutes");
                    Equipment e7 = new Equipment("tables expé");
                    equipmentRepository.save(e1);
                    equipmentRepository.save(e2);
                    equipmentRepository.save(e3);
                    equipmentRepository.save(e4);
                    equipmentRepository.save(e5);
                    equipmentRepository.save(e6);
                    equipmentRepository.save(e7);
                    Classroom c1 = new Classroom("salle visio");
                    Classroom c2 = new Classroom("salle informatique");
                    Classroom c3 = new Classroom("salle experienceBio");
                    Classroom c4 = new Classroom("salle experienceChim");
                    Classroom c5 = new Classroom("salle musqiue");
                    Classroom c6 = new Classroom("salle E300");
                    Classroom c7 = new Classroom("gymnase");
                    clrepository.save(c1);
                    clrepository.save(c2);
                    clrepository.save(c3);
                    clrepository.save(c4);
                    clrepository.save(c5);
                    clrepository.save(c6);
                    clrepository.save(c7);
                    StudentClass stCl1 = new StudentClass("5èmeA");
                    StudentClass stCl2 = new StudentClass("5èmeB");
                    StudentClass stCl3 = new StudentClass("5èmeC");
                    StudentClass stCl4 = new StudentClass("5èmeD");
                    StudentClass stCl5 = new StudentClass("5èmeE");
                    strepository.save(stCl1);
                    strepository.save(stCl2);
                    strepository.save(stCl3);
                    strepository.save(stCl4);
                    strepository.save(stCl5);

                    Student student = new Student("Akim", "lou","akim","NB",stCl1 );
                    Student student1 = new Student("Francis", "poupo","francis","Poupo",stCl2);
                    Student student2 = new Student("Pauline", "titi","Pauline","titi",stCl2);
                    Student student3 = new Student("Sophie", "lala","Soph","lala",stCl3);
                    Student student4 = new Student("Henry", "voltaire","Guy","Demaupa",stCl4);
                    stRepo.save(student);
                    stRepo.save(student1);
                    stRepo.save(student2);
                    stRepo.save(student3);
                    stRepo.save(student4);
                    urepository.save(new Unavailability("Histoire", "03/27/2020 09:00:00","03/18/2020 12:00:00",pA, c3,stCl3,e1));
                    urepository.save(new Unavailability("Français", "03/26/2020 14:00:00","03/19/2020 17:00:00",pAk,c6,stCl2,e1));
                    urepository.save(new Unavailability("Bio", "03/28/2020 11:00:00","03/20/2020 12:00:00",pM,c3,stCl1,e7));
                    urepository.save(new Unavailability("Musique", "03/26/2020 12:00:00","03/20/2020 14:00:00",pM,c5,stCl1,e6));
                    urepository.save(new Unavailability("Chimie", "03/27/2020 10:00:00","03/20/2020 12:00:00",pV,c4,stCl2,e7));
                    urepository.save(new Unavailability("Physique", "03/27/2020 08:00:00","03/20/2020 12:00:00",pM,c1,stCl3,e1));
                    urepository.save(new Unavailability("EPS", "03/27/2020 08:00:00","03/20/2020 12:00:00",pM,c7,stCl3,e3));

                    System.out.println(student1.getPassword());
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
