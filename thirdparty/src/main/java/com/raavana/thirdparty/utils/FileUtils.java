package com.raavana.thirdparty.utils;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Base64;
import java.util.Iterator;

public class FileUtils {

        public static class ImageCompressionException extends Exception {
                public ImageCompressionException(String message) {
                        super(message);
                }

                public ImageCompressionException(String message, Throwable cause) {
                        super(message, cause);
                }
        }
        public static String compressBase64Image(String base64Image) throws ImageCompressionException {
                if (base64Image == null || base64Image.isEmpty()) {
                        throw new ImageCompressionException("Input Base64 string is empty or null.");
                }

                try {
                        if (base64Image.startsWith("data:image")) {
                                base64Image = base64Image.substring(base64Image.indexOf(",") + 1);
                        }
                        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

                        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
                        BufferedImage originalImg = ImageIO.read(bis);
                        if (originalImg == null) {
                                throw new ImageCompressionException("Decoded bytes are not a valid image format.");
                        }

                        BufferedImage rgbImage = new BufferedImage(
                                originalImg.getWidth(),
                                originalImg.getHeight(),
                                BufferedImage.TYPE_INT_RGB
                        );
                        Graphics2D g = rgbImage.createGraphics();
                        g.drawImage(originalImg, 0, 0, Color.WHITE, null);
                        g.dispose();

                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpeg");
                        if (!writers.hasNext()) {
                                throw new ImageCompressionException("No JPEG writers available.");
                        }

                        ImageWriter writer = writers.next();
                        ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
                        writer.setOutput(ios);

                        ImageWriteParam param = writer.getDefaultWriteParam();
                        if (param.canWriteCompressed()) {
                                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                                param.setCompressionQuality(0.6f);
                        }

                        writer.write(null, new IIOImage(rgbImage, null, null), param);

                        ios.close();
                        writer.dispose();

                        byte[] compressedBytes = baos.toByteArray();
                        return Base64.getEncoder().encodeToString(compressedBytes);

                } catch (IllegalArgumentException e) {
                        throw new ImageCompressionException("Invalid Base64 input.", e);
                } catch (IOException e) {
                        throw new ImageCompressionException("I/O error during compression.", e);
                }
        }

        // Demo
//        public static void main(String[] args) {
//                try {
//                        URL imageUrl = new URL("https://dummyjson.com/image/400x200/008080/ffffff?text=Hello+Peter");
//                        BufferedImage img = ImageIO.read(imageUrl);
//
//                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                        ImageIO.write(img, "png", baos);
//                        String base64Input = Base64.getEncoder().encodeToString(baos.toByteArray());
//
//                        String base64Output = compressBase64Image(base64Input);
//
//                        System.out.println("Original Base64 length: " + base64Input.length());
//                        System.out.println("Compressed Base64 length: " + base64Output.length());
//
//                        byte[] outputBytes = Base64.getDecoder().decode(base64Output);
//                        try (FileOutputStream fos = new FileOutputStream("compressed.jpg")) {
//                                fos.write(outputBytes);
//                        }
//
//                        System.out.println("Compressed image saved as compressed.jpg ");
//
//                } catch (Exception e) {
//                        e.printStackTrace();
//                }
//        }
}
