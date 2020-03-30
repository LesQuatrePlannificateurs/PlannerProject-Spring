package com.spring.planner.repository;

import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Director;
import com.spring.planner.entities.Person;
import com.spring.planner.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DirectorRepository extends CrudRepository<Director, Long> {

    @Query("SELECT d FROM Director d WHERE d.login=:param")
    Director findByLogin(@Param("param")String login);

}
