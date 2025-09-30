package com.designpatterns.behavioural.command;

// A Concrete Command
public class SteakCommand implements IOrder {
    private final Kitchen kitchen;

    public SteakCommand(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void execute() {
        kitchen.cookSteak();
    }
}