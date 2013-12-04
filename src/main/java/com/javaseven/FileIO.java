package com.javaseven;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileIO {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("e:/text");
		
		Path file = Files.createFile(path);
		
		BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);

	}

}
