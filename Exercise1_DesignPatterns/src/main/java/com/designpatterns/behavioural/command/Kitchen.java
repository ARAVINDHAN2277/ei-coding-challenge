package com.designpatterns.behavioural.command;

// The Receiver
public class Kitchen {
    public void cookSteak() {
        System.out.println("Kitchen is cooking a steak.");
    }

    public void prepareSalad() {
        System.out.println("Kitchen is preparing a salad.");
    }
}