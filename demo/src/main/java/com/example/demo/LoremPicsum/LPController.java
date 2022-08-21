package com.example.demo.LoremPicsum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/lp")
public class LPController {
    private final LPService lpService;

    @Autowired
    public LPController(LPService lpService) {
        this.lpService = lpService;
    }

    @GetMapping
    public int getLP() {
        return lpService.getLP();
    }

    @GetMapping(value="/test")
    public String foo() {
        return lpService.foo();
    }
}

