package com.konor.HomeWorkPracticeOther8;

import java.io.*;

public class DataIODemo {
    public static void main(String[] args) {
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("topjavatest.dat"))) {
            dout.writeDouble(98.6);
            dout.writeInt(100);
            dout.writeBoolean(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (DataInputStream din = new DataInputStream(new FileInputStream("topjavatest.dat"))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();

            System.out.println("d, i, b - " + d + " " + i + " " + " " + b);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
