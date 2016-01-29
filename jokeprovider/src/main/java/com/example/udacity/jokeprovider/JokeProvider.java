package com.example.udacity.jokeprovider;

import java.util.Random;

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

    /* This method returns a random joke from the jokes set available in the library */
    public String tellJoke() {
        int random = new Random().nextInt(Utility.NUM_JOKES);
        return Utility.ENGLISH_JOKES.get(random);
    }
}
