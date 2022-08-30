package com.learn.demo.LoremPicsum;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LPService {
    private final String fileName = "uploads/image.jpg";

    private final String todoUrl = "demo/src/main/resources/templates/lp.html";

    String todo;
    List<String> todoList;

    public void postTodo(String payload) {
        try {
            URL url = new URL(todoUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/plain; charset=UTF-8");
            con.setRequestProperty("Accept", "text/plain");
            con.setDoOutput(true);
            byte[] out = payload.getBytes(StandardCharsets.UTF_8);
            con.getOutputStream().write(out);
            int stat = con.getResponseCode();
            System.out.println(con.getResponseMessage());
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            todo="bad";
        } catch (IOException e) {
            e.printStackTrace();
            todo="bad2";
        }
    }

    public List<String> getTodo() {
        try {
            URL url = new URL(todoUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
            con.setConnectTimeout(2000);
            con.setReadTimeout(1000);
            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            todo = content.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            todo="bad";
        } catch (IOException e) {
            e.printStackTrace();
            todo="bad2";
        }
        JSONArray jsonArray = new JSONArray(todo);
        List<String> todoList = jsonArray.toList().stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        return todoList;
    }

    public void getLP() {
//        if (true) {
        if (imageExpired()) {
            try {
                downloadLP();
            } catch (IOException e) {
                // handle IOException
                System.out.printf("TODO");
            }
        } else {
            System.out.println("not exp");
        }
    }

    private long getTodaysEpoch() {
        ZonedDateTime zdt = ZonedDateTime.now(ZoneOffset.UTC);
        LocalDate ldt = zdt.toLocalDate();
        ZonedDateTime startOfDay = ldt.atStartOfDay(ZoneOffset.UTC);
        return startOfDay.toInstant().toEpochMilli();
    }

    private long getFileLastModEpoch() {
        return new File(fileName).lastModified();
    }

    private boolean imageExpired() {
        long todaysEpoch = getTodaysEpoch();
        long fileEpoch = getFileLastModEpoch();
        long daysSinceFileLastModified = Instant.ofEpochMilli(fileEpoch).until(Instant.ofEpochMilli(todaysEpoch), ChronoUnit.DAYS);
        return daysSinceFileLastModified > 0;
    }

    private void downloadLP() throws IOException{
        URL url = new URL("https://picsum.photos/1200");
        BufferedImage image = ImageIO.read(url);
        File outputFile = new File(fileName);
        ImageIO.write(image, "jpg", outputFile);
    }

}
