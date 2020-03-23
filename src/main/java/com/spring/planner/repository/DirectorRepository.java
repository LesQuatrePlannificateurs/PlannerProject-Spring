package com.spring.planner.repository;

import com.spring.planner.entities.Classroom;
import com.spring.planner.entities.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {
}
