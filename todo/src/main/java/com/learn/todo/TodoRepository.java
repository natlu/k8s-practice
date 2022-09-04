package com.learn.todo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    Todo findById(long id);

    @Query("SELECT item FROM #{#entityName}")
    List<String> getAllItems();

}