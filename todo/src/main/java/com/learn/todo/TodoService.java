package com.learn.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<String> getTodo() {
        return todoRepository.getAllItems();
    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

//    List<Todo> todo = new ArrayList<>();
//    public List<String> getTodo() {
//        return todo;
//    }
//    public void addTodo(String todoItem) {
//        todo.add(todoItem);
//    }

}
