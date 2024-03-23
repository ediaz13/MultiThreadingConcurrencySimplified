package org.mogul.section4.image_processing;

public class Main {
    public static void main(String[] args) {

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
