package com.designpatterns.creational.singleton;

public class GameSettings {
    private static GameSettings instance;
    private int volume = 75;
    private String difficulty = "Normal";

    private GameSettings() {
        System.out.println("GameSettings loaded.");
    }

    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }

    public int getVolume() { return volume; }
    public void setVolume(int volume) { this.volume = volume; }
}