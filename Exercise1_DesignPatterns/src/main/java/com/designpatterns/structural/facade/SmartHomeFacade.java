package com.designpatterns.structural.facade;

import com.designpatterns.structural.facade.subsystems.*;

public class SmartHomeFacade {
    private final LightingSystem lighting = new LightingSystem();
    private final SecuritySystem security = new SecuritySystem();
    private final Thermostat thermostat = new Thermostat();

    public void leaveHome() {
        System.out.println("\nPreparing to leave home...");
        lighting.turnOffAllLights();
        thermostat.setEcoMode();
        security.arm();
        System.out.println("Goodbye!");
    }

    public void arriveHome() {
        System.out.println("\nPreparing for arrival...");
        security.disarm();
        thermostat.setComfortMode();
        lighting.turnOnAllLights();
        System.out.println("Welcome home!");
    }
}