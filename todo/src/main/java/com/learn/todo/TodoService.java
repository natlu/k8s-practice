package com.learn.todo;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TodoService {

    public int getTodo() {
        Random rand = new Random();
        int upperbound = 99;
        return rand.nextInt(upperbound);
    }

    public void addTodo(String todoItem) {
        System.out.printf(todoItem);
    }

}
