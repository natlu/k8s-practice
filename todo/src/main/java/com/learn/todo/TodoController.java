package com.learn.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "todo/api/v1/todo")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<String> getTodo() {
        return todoService.getTodo();

    }

    @PostMapping
    public void addTodo(@RequestBody String todoItem) {
        todoService.addTodo(todoItem);
    }

}
