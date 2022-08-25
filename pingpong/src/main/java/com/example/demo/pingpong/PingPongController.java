package com.example.demo.pingpong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "pingpong")
public class PingPongController {
    private final PingPongService ppService;

    @Autowired
    public PingPongController(PingPongService ppService) {
        this.ppService = ppService;
    }

    @GetMapping
    public String doPong() {
        return ppService.doPong();
    }

    @GetMapping(path = "current")
    public String getPong() {
        return ppService.getPong();
    }
}
