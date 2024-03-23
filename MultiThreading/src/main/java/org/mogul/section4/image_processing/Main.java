package org.mogul.section4.image_processing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static final String SOURCE_FILE = "./resources/many-flowers.jpg";
    public static final String DESTINATION_FILE = "./out/many-flowers.jpg";

    public static void main(String[] args) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(SOURCE_FILE));
        BufferedImage resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

    }

    public static void recolorPixel (BufferedImage originalImage, BufferedImage resultImage, int x, int y) {

    }

    public static boolean isShadeGray( int red, int green, int blue) {
        return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(green - blue) < 30;
    }

    public static int createRGBFromColours(int red, int green, int blue) {
        int rgb = 0;
        rgb |= blue;
        rgb |= green << 8;
        rgb |= red << 16;

        rgb |= 0xFF000000;

        return rgb;
    }

    public static int getRed (int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }
    public static int getGreen (int rgb) {
        return (rgb & 0x0000FF00) >> 16;
    }
    public static int getBlue (int rgb) {
        return rgb & 0x000000FF;
    }
}
