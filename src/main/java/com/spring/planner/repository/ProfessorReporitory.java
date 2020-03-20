package com.spring.planner.repository;

import com.spring.planner.entities.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorReporitory extends CrudRepository<Professor,Long> {
}
