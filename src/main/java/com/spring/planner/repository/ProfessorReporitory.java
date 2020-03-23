package com.spring.planner.repository;

import com.spring.planner.entities.Professor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProfessorReporitory extends CrudRepository<Professor,Long> {

    @Query("SELECT p FROM Professor p WHERE p.login=:param")
     Professor findByLogin(@Param("param")String login);
}
