package com.raavana.thirdparty.utils;

import java.io.*;

public class FileCompression {
    public static void main(String[] args) {

        String inputFile = "file.pdf";  // original file
        String outputFile = "outputfile.pdf"; // reduced file (50%)

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            File original = new File(inputFile);
            long originalSize = original.length();
            long halfSize = originalSize / 2;  // 50%
            byte[] buffer = new byte[1024];
            long written = 0;
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1 && written < halfSize) {
                long bytesToWrite = Math.min(bytesRead, halfSize - written);
                fos.write(buffer, 0, (int) bytesToWrite);
                written += bytesToWrite;
            }

            System.out.println("File reduced successfully!");
            System.out.println("Original size: " + originalSize + " bytes");
            System.out.println("Reduced size:  " + written + " bytes");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
