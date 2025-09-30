package com.designpatterns.structural.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        // Create sharers for different platforms
        IShareable twitterSharer = new TwitterApi();
        IShareable facebookSharer = new FacebookShareAdapter();

        String message = "Design patterns are awesome!";

        // The client code uses the same interface for both
        shareOnSocialMedia(twitterSharer, message);
        shareOnSocialMedia(facebookSharer, message);
    }

    // Our application's method only knows about the IShareable interface
    public static void shareOnSocialMedia(IShareable sharer, String message) {
        sharer.share(message);
    }
}