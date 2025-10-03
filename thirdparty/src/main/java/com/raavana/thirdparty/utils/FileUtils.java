package com.raavana.thirdparty.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Base64;

public class FileUtils {

    // Compress Base64 image
    public String compressBase64Image(String base64Input) throws IOException {
        if (base64Input == null || base64Input.isEmpty()) {
            throw new IOException("Input Base64 string is empty or null.");
        }

        // Remove data:image prefix if present
        if (base64Input.startsWith("data:image")) {
            base64Input = base64Input.substring(base64Input.indexOf(",") + 1);
        }

        byte[] imageBytes = Base64.getDecoder().decode(base64Input);

        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
        BufferedImage originalImg = ImageIO.read(bis);
        if (originalImg == null) {
            throw new IOException("Decoded bytes are not a valid image.");
        }

        // Reduce by 60%
        int newWidth = (int) (originalImg.getWidth() * 0.4);
        int newHeight = (int) (originalImg.getHeight() * 0.4);
        BufferedImage resizedImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = resizedImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(originalImg, 0, 0, newWidth, newHeight, null);
        g.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resizedImg, "png", baos);
        byte[] compressedBytes = baos.toByteArray();

        return Base64.getEncoder().encodeToString(compressedBytes);
    }
    // Demo
//    public static void main(String[] args) {
//        try {
//
//            URL imageUrl = new URL("https://dummyjson.com/image/400x200/008080/ffffff?text=Hello+Peter");
//            BufferedImage img = ImageIO.read(imageUrl);

//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(img, "png", baos);
//            String base64Input = Base64.getEncoder().encodeToString(baos.toByteArray());
//

//            String base64Output = compressBase64Image(base64Input);
//
//            // Print lengths
//            System.out.println("Original Base64 length: " + base64Input.length());
//            System.out.println("Compressed Base64 length: " + base64Output.length());
//
//            // save compressed image
//            byte[] outputBytes = Base64.getDecoder().decode(base64Output);
//            try (FileOutputStream fos = new FileOutputStream("compressed.png")) {
//                fos.write(outputBytes);
//            }
//            System.out.println("Compressed image saved as compressed.png");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

