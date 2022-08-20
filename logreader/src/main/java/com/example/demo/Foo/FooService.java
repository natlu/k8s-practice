package com.example.demo.Foo;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Service
public class FooService {

    private static final String fileDir = System.getenv("FILE_DIR") + "/filename.txt";
    private static final String pingpongDir = System.getenv("FILE_DIR") + "/pingpong.txt";

    public String getFoo() {
        String data = readLog(fileDir);
        System.out.println(data);
        String dataPingPong = readLog(pingpongDir);
        System.out.println(dataPingPong);
        return data + "\n" + dataPingPong;
    }

    public String readLog(String fileDir) {
        try {
            File myObj = new File(fileDir);
            Scanner myReader = new Scanner(myObj);
            // know it's only 1 line so no iteration needed
            String data = myReader.nextLine();
            myReader.close();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "sad";
        }
    }

}

