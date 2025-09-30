package com.designpatterns.creational.factory;

public class DocumentFactory {
    public static IDocumentConverter getConverter(String type) {
        if (type == null) return null;
        if (type.equalsIgnoreCase("PDF")) return new PdfConverter();
        if (type.equalsIgnoreCase("DOCX")) return new DocxConverter();
        return null;
    }
}