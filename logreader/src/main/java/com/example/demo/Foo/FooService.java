package com.example.demo.Foo;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Service
public class FooService {

    public String getFoo() {
        String data = readLog();
        System.out.println(data);
        return data;
    }

    public static String readLog() {
        try {
            File myObj = new File("filename.txt");
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

    public static void writeToFile(String contents) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(contents);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}

