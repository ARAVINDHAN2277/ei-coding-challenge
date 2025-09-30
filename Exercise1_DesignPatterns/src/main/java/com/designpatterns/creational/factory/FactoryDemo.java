package com.designpatterns.creational.factory;

public class FactoryDemo {
    public static void main(String[] args) {
        IDocumentConverter pdfConverter = DocumentFactory.getConverter("PDF");
        pdfConverter.convert("MyAnnualReport.txt");
        System.out.println("---");
        IDocumentConverter docxConverter = DocumentFactory.getConverter("DOCX");
        docxConverter.convert("MyAnnualReport.txt");
    }
}