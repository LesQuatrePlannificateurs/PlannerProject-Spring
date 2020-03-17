package com.spring.planner.repository;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository<T> extends CrudRepository<T,Long> {


}
