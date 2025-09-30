package com.designpatterns.creational.factory;

public class PdfConverter implements IDocumentConverter {
    @Override
    public void convert(String inputFilePath) {
        System.out.println("Converting " + inputFilePath + " to PDF format...");
        System.out.println("Conversion to PDF complete.");
    }
}