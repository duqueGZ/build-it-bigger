package com.udacity.gradle.builditbigger.testing;

import com.example.udacity.jokeprovider.JokeProvider;

import junit.framework.Assert;

import org.junit.Test;

public class JokeProviderTest {
    @Test
    public void tellJokeTest() {
        String joke = JokeProvider.getInstance().tellJoke();
        Assert.assertNotNull(joke);
        Assert.assertFalse(joke.isEmpty());
    }
}
