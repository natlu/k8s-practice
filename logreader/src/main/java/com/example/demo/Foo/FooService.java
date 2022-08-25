package com.example.demo.Foo;

import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

@Service
public class FooService {

    private static final String fileDir = System.getenv("FILE_DIR") + "/logwriter.txt";
    private static final String pingpongDir = System.getenv("FILE_DIR") + "/pingpong.txt";


    public String getFoo() {
        String data = readLog(fileDir);
        System.out.println(data);
//        String dataPingPong = readLog(pingpongDir);
//        System.out.println(dataPingPong);

        String dataPingPong;
        try {
            URL url = new URL("http://pingpong-svc/pingpong/current");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
            con.setConnectTimeout(2000);
            con.setReadTimeout(1000);
            int status = con.getResponseCode();
            System.out.printf("response status" + status);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            dataPingPong = content.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            dataPingPong="no ping pong";
        } catch (IOException e) {
            e.printStackTrace();
            dataPingPong="no ping pong!";
        }

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

