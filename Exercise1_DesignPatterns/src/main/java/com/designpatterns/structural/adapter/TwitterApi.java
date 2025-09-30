package com.designpatterns.structural.adapter;

// A class that already works with our Target Interface
public class TwitterApi implements IShareable {
    @Override
    public void share(String message) {
        System.out.println("Sharing to Twitter: '" + message + "'");
    }
}