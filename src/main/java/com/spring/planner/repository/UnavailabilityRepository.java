package com.spring.planner.repository;

import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Unavailability;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UnavailabilityRepository extends CrudRepository<Unavailability, Long> {

   // Attention, on cherche à trouver une indispo par classroom, donc cette requete doit apparaitre dans la classe UnavailabilityRepository
    //u.id, u.nameIndispo, u.start, u.end, u.professor.professorId, u.classroom.classroomId, u.equipment.equipmentId, u.studentClass.name

    @Query("SELECT u FROM Unavailability u WHERE u.classroom.classroomId=:param")
    Iterable<Unavailability> findUnavailabilityByClassroomId(@Param("param")Long id);

    @Query("SELECT u FROM Unavailability u WHERE u.professor.professorId=:param")
    Iterable<Unavailability> findUnavailabilityByProfessorId(@Param("param")Long id);

    @Query("SELECT u FROM Unavailability u WHERE u.equipment.equipmentId=:param")

//    @Query("SELECT u.id, u.nameIndispo, u.start, u.end, u.professor.lastname,  u.classroom.name, u.equipment.equimpentName, u.studentClass.name FROM Unavailability u WHERE u.classroom.classroomId=:param")
//    Iterable<Unavailability> findUnavailabilityByClassroomId(@Param("param")Long id);
//
//    @Query("SELECT u.id, u.nameIndispo, u.start, u.end, u.professor.lastname,  u.classroom.name, u.equipment.equimpentName, u.studentClass.name FROM Unavailability u WHERE u.professor.professorId=:param")
//    Iterable<Unavailability> findUnavailabilityByProfessorId(@Param("param")Long id);
//
//    @Query("SELECT u.id, u.nameIndispo, u.start, u.end, u.professor.lastname,  u.classroom.name, u.equipment.equimpentName, u.studentClass.name FROM Unavailability u WHERE u.equipment.equipmentId=:param")

    Iterable<Unavailability> findUnavailabilityByEquipmentId(@Param("param")Long id);

    @Query("SELECT u FROM Unavailability u WHERE u.studentClass.studentClassId=:param")
    Iterable<Unavailability> findUnavailabilityByStudentClassId(@Param("param")Long id);

}
