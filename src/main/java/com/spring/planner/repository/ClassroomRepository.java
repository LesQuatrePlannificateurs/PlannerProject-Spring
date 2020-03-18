package com.spring.planner.repository;

import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Unavailability;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends CrudRepository<Classroom, Long> {

    @Query("SELECT u FROM Unavailability u WHERE u.classroomId=:param")
    Iterable<Unavailability> findUnavailabilityByClassroomId(@Param("param")Long id);

}
