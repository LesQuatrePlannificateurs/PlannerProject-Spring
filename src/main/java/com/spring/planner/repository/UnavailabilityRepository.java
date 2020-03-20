package com.spring.planner.repository;

import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Unavailability;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UnavailabilityRepository extends CrudRepository<Unavailability, Long> {

    //Attention, on cherche à trouver une indispo par classroom, donc cette requete doit apparaitre dans la classe UnavailabilityRepository
    @Query("SELECT u FROM Unavailability u WHERE u.classroomId=:param")
    Iterable<Unavailability> findUnavailabilityByClassroomId(@Param("param")Long id);

    @Query("SELECT u FROM Unavailability u WHERE u.profId=:param")
    Iterable<Unavailability> findUnavailabilityByProfessorId(@Param("param")Long id);
}
