package com.designpatterns.behavioural.command;

// A Concrete Command
public class SaladCommand implements IOrder {
    private final Kitchen kitchen;

    public SaladCommand(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void execute() {
        kitchen.prepareSalad();
    }
}