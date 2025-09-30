package com.designpatterns.creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        GameSettings settings1 = GameSettings.getInstance();
        System.out.println("Settings 1 Volume: " + settings1.getVolume());
        settings1.setVolume(90);

        GameSettings settings2 = GameSettings.getInstance();
        System.out.println("Settings 2 Volume: " + settings2.getVolume());
        System.out.println("Are settings1 and settings2 the same? " + (settings1 == settings2));
    }
}