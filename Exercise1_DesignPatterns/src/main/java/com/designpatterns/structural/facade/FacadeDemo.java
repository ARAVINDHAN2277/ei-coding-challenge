package com.designpatterns.structural.facade;

public class FacadeDemo {
    public static void main(String[] args) {
        SmartHomeFacade smartHome = new SmartHomeFacade();
        smartHome.arriveHome();
        smartHome.leaveHome();
    }
}