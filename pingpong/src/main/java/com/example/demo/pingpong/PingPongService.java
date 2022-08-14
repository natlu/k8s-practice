package com.example.demo.pingpong;

import org.springframework.stereotype.Service;

@Service
public class PingPongService {
    int i = 0;
    public String getPong() {
        String out = "Pong " + String.valueOf(i);
        i = i + 1;
        return(out);
    }
}
