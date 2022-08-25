package com.example.demo.pingpong;

import org.springframework.stereotype.Service;

import static com.example.demo.DemoApplication.writeToFile;

@Service
public class PingPongService {
    int i = 0;

    public String doPong() {
        i = i + 1;
        String out = "Pong " + String.valueOf(i);
        writeToFile("Ping / Pongs: " + String.valueOf(i));
        return(out);
    }

    public String getPong() {
        String out = "Pong " + String.valueOf(i);
        return(out);
    }

}
