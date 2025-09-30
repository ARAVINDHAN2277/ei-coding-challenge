package com.designpatterns.behavioural.command;

public class CommandDemo {
    public static void main(String[] args) {
        // The Receiver
        Kitchen kitchen = new Kitchen();

        // Concrete Commands
        IOrder steakOrder = new SteakCommand(kitchen);
        IOrder saladOrder = new SaladCommand(kitchen);

        // The Invoker
        Waiter waiter = new Waiter();

        // Waiter takes and executes orders
        waiter.takeOrder(steakOrder);
        System.out.println("---");
        waiter.takeOrder(saladOrder);
    }
}