package com.designpatterns.behavioural.strategy;

// The Context
public class ImageCompressor {
    private ICompressionStrategy strategy;

    public ImageCompressor(ICompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ICompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compressImage(String imageName) {
        System.out.println("--- Compressing Image ---");
        strategy.compress(imageName);
        System.out.println("-------------------------");
    }
}