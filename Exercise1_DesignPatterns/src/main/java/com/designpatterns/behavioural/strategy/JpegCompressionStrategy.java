package com.designpatterns.behavioural.strategy;

// A Concrete Strategy
public class JpegCompressionStrategy implements ICompressionStrategy {
    @Override
    public void compress(String imageName) {
        System.out.println("Compressing " + imageName + " using JPEG (high quality).");
    }
}