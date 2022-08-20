package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	public static final String fileDir = System.getenv("FILE_DIR") + "/filename.txt";

	public static void main(String[] args) {
		createFile();
		SpringApplication.run(DemoApplication.class, args);
	}

	public static void createFile() {
		try {
			File myObj = new File(fileDir);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}


}
