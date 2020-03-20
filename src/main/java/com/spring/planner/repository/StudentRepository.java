package com.spring.planner.repository;

import com.spring.planner.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository <Student, Long> {

}
