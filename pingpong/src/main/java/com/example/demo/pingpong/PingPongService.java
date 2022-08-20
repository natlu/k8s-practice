package com.example.demo.pingpong;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.example.demo.DemoApplication.writeToFile;
import static java.nio.file.Files.createFile;

@Service
public class PingPongService {
    int i = 0;

    public String getPong() {
        String out = "Pong " + String.valueOf(i);
        writeToFile("Ping / Pongs: " + String.valueOf(i));
        i = i + 1;
        return(out);
    }

}
