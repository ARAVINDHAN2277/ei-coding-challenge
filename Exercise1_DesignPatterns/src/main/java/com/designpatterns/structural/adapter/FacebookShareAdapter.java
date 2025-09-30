package com.designpatterns.structural.adapter;

import com.designpatterns.structural.adapter.thirdparty.FacebookSdk;

// The Adapter
public class FacebookShareAdapter implements IShareable {
    private final FacebookSdk facebookSdk;

    public FacebookShareAdapter() {
        this.facebookSdk = new FacebookSdk();
    }

    @Override
    public void share(String message) {
        // The adapter translates the call to the adaptee's format
        facebookSdk.postUpdate(message);
    }
}