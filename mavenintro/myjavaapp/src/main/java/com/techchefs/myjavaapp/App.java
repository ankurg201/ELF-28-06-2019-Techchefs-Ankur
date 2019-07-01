package com.techchefs.myjavaapp;

import com.techchefs.filecreationutilnew.util.CreateFileUtil;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
     
        CreateFileUtil createFileUtil = new CreateFileUtil();
        createFileUtil.createFile("hello.txt", "my java app text");
        
    }
}
