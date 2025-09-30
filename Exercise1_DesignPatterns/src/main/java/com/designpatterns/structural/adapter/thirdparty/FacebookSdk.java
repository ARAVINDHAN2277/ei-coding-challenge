package com.designpatterns.structural.adapter.thirdparty;

// The Adaptee: A third-party class with an incompatible interface
public class FacebookSdk {
    public void postUpdate(String status) {
        System.out.println("Posting status to Facebook: '" + status + "'");
    }
}