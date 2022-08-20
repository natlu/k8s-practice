package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static final String pingpongDir = System.getenv("FILE_DIR") + "/pingpong.txt";

	public static void main(String[] args) {
		createFile();
		SpringApplication.run(DemoApplication.class, args);
	}

	public static void createFile() {
		try {
			File myObj = new File(pingpongDir);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
				writeToFile("Ping / Pongs: " + String.valueOf(0));
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void writeToFile(String contents) {
		try {
			FileWriter myWriter = new FileWriter(pingpongDir);
			myWriter.write(contents);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
