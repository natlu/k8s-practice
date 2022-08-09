package com.example.demo.Foo;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FooService {

    public int getFoo() {
        Random rand = new Random();
        int upperbound = 99;
        return rand.nextInt(upperbound);
    }

}

