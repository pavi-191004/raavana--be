package com.raavana.thirdparty.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileUtils {
    public void imageCompress() throws IOException {
        File inputFile = new File("nature.jpg");
        File outFile   = new File("opImage.jpg");

        Image img = ImageIO.read(inputFile);
        String fileType = "jpg";

        // calculate 60% of original size
        int newWidth = (int) (img.getWidth(null) * 0.6);
        int newHeight = (int) (img.getHeight(null) * 0.6);

        BufferedImage tempImg = resizeImage(img, newWidth, newHeight);

        ImageIO.write(tempImg, fileType, outFile);
        System.out.println("Image compressed successfully!");
    }

    public BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);

        // High quality rendering
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();

        return bufferedImage;
    }

    public static void main(String[] args) {
        try {
            new FileUtils().imageCompress();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
