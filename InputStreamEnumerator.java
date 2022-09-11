package com.konor.HomeWorkPracticeOther8;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;


public class InputStreamEnumerator implements Enumeration<FileInputStream> {

    private Enumeration<String> files;


    public InputStreamEnumerator(Vector<String> files) {
        this.files = files.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement().toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
class SequenceInputStreamDemo{
    public static void main(String[] args) {

        int c;
        Vector<String>files = new Vector<>();

        files.addElement("file1.txt");
        files.addElement("file2.txt");
        files.addElement("file3.txt");

        InputStreamEnumerator ise = new InputStreamEnumerator(files);

        InputStream input = new SequenceInputStream(ise);

        while (true) {
            try {
                if (!((c = input.read()) != -1)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    input.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println((char) c);
        }
    }

}
