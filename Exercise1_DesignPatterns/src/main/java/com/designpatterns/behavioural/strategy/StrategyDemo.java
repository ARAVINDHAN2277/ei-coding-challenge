package com.designpatterns.behavioural.strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        String myImage = "VacationPhoto.raw";

        // Start with JPEG compression
        ImageCompressor compressor = new ImageCompressor(new JpegCompressionStrategy());
        compressor.compressImage(myImage);

        // Change the strategy at runtime to PNG
        System.out.println("\nUser changed preference to PNG...");
        compressor.setStrategy(new PngCompressionStrategy());
        compressor.compressImage(myImage);
    }
}