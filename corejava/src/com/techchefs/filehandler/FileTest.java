package com.techchefs.filehandler;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {

		String msg = "hello";
		byte[] by = msg.getBytes();
		try (FileOutputStream fout = new FileOutputStream("Test.txt")) {
			fout.write(by);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
