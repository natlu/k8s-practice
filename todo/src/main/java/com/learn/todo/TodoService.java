package com.learn.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TodoService {

    List<String> todo = new ArrayList<String>();

    public List<String> getTodo() {
        return todo;
    }

    public void addTodo(String todoItem) {
        todo.add(todoItem);
    }

}
