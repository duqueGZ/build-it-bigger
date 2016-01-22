package com.example.udacity.jokeprovider;

public class JokeProvider {

    private static JokeProvider instance = null;

    private JokeProvider() {
        // In order to avoid direct instantiation
    }

    public synchronized static JokeProvider getInstance() {
        if (instance==null) {
            instance = new JokeProvider();
        }
        return instance;
    }

    public String tellJoke() {
        return "This is a funny joke";
    }
}
