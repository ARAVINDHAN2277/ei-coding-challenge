package com.designpatterns.structural.facade.subsystems;

public class SecuritySystem {
    public void arm() { System.out.println("Security: System is ARMED."); }
    public void disarm() { System.out.println("Security: System is DISARMED."); }
}