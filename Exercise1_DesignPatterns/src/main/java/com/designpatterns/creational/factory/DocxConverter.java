package com.designpatterns.creational.factory;

public class DocxConverter implements IDocumentConverter {
    @Override
    public void convert(String inputFilePath) {
        System.out.println("Converting " + inputFilePath + " to DOCX format...");
        System.out.println("Conversion to DOCX complete.");
    }
}