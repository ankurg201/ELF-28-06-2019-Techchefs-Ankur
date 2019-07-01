package com.techchefs.filecreationutilnew;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.techchefs.filecreationutilnew.util.CreateFileUtil;

public class CreateFileUtilTest {
	
	private CreateFileUtil util = new CreateFileUtil();
	
	@Test
	public void createFileTest() {
		boolean expected = true;
		boolean actual = util.createFile("MyText.txt", "This is a test file");
		
		assertEquals(expected, actual);
	}
}
