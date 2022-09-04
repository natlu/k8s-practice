package com.learn.todo;

import javax.persistence.*;
import java.lang.reflect.GenericArrayType;

@Entity
@Table(name="footbl")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;

    public Todo() {
    }

    public Todo(Long id) {
    }

    public Todo(Long id, String item) {
        this.id = id;
        this.item = item;
    }

    public Todo(String item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", item=" + item +
                '}';
    }
}
