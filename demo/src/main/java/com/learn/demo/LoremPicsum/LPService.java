package com.example.demo.LoremPicsum;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.net.URL;
import java.io.File;

@Service
public class LPService {
    private final String fileName = "uploads/image.jpg";


    public String foo() {
        long lm = new File(fileName).lastModified();
        Instant instant = Instant.ofEpochMilli(lm);
        return instant.toString();
        // ZoneId zid = ZoneId.of("Antarctica/Casey");
        // LocalDateTime ldt = LocalDateTime.ofInstant(instant, zid);
        // return ldt.toString();
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