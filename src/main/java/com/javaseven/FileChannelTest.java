package com.javaseven;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("test.log");
		
		System.out.println("Absolute Path for test.log : " + path.toAbsolutePath());
		
		/*ByteBuffer buffer = ByteBuffer.allocate(1024);
		FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
		
		channel.read(buffer, channel.size() - 1000);
		
		System.out.println(new String(buffer.array()));*/
		
		AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
		
	}

}
