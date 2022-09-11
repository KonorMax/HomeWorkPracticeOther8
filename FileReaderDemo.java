package com.konor.HomeWorkPracticeOther8;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("C:\\TopJavaLeaning\\src\\main\\java\\com\\konor\\HomeWorkPracticeOther8\\FileReaderDemo.java")){
            int c;

            while ((c = fr.read()) != -1){
                System.out.print((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
