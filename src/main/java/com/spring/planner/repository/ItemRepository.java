package com.spring.planner.repository;

import com.spring.planner.entities.Item;
import com.spring.planner.entities.Unavailability;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ItemRepository extends CrudRepository<Item,Long> {



}
