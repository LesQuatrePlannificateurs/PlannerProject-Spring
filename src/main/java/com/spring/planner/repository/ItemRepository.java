package com.spring.planner.repository;

import com.spring.planner.entities.Unavailability;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository<T> extends CrudRepository<T,Long> {

    @Query("select c from unavailability_classroom_timeslot c WHERE c.classroom_name=:param")
    Iterable<Unavailability> findAllByClassroomName(@Param("param") String classroomName);


}
