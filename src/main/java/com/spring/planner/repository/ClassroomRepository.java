package com.spring.planner.repository;

import com.spring.planner.entities.Classroom;
import org.springframework.data.repository.CrudRepository;


public interface ClassroomRepository extends CrudRepository<Classroom, Long> {

// Cette classe nous permet de trouver une ClassroomName by id, ou d'ajouter/delete une classeroom



}
