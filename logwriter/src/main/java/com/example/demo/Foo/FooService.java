package com.example.demo.Foo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

@Service
public class FooService {
    private static final String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    private static final String fileDir = System.getenv("FILE_DIR") + "/filename.txt";
    String currLog;

    public String getFoo() {
        return currLog;
    }

    @Scheduled(fixedRate=5000)
    public void genLog() {
        Random rand = new Random();
        int upperbound = 99;
        currLog = String.valueOf(rand.nextInt(upperbound));
        writeToFile(timeStamp  + ":" + currLog);
    }

    public static void writeToFile(String contents) {
        try {
            FileWriter myWriter = new FileWriter(fileDir);
            myWriter.write(contents);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}

