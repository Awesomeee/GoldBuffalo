package com.goldbuffalo.springapplication;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class WebService {
	
	public void WriteFile(byte[] fileContent) {
		Path path = Paths.get("/Users/duy/Data/2024/Working/File-Server/banana.jpg");
		
		try {
			Files.write(path, fileContent);
			System.out.println("Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
