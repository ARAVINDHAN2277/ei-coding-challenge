package com.designpatterns.behavioural.command;

// The Invoker
public class Waiter {
    private IOrder order;

    public void takeOrder(IOrder order) {
        this.order = order;
        System.out.println("Waiter took an order.");
        sendOrderToKitchen();
    }

    private void sendOrderToKitchen() {
        order.execute();
    }
}