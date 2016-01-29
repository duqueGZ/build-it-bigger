package com.udacity.gradle.builditbigger.testing;

import com.example.udacity.jokeprovider.JokeProvider;

import junit.framework.Assert;

import org.junit.Test;

public class JokeProviderTest {

    private static final String SPANISH_LOCALE = "es";

    @Test
    public void tellJokeDefaultLocaleTest() {
        String joke = JokeProvider.getInstance().tellJoke();
        Assert.assertNotNull(joke);
        Assert.assertFalse(joke.isEmpty());
    }

    @Test
    public void tellJokeSpanishLocaleTest() {
        String joke = JokeProvider.getInstance().tellJoke(JokeProviderTest.SPANISH_LOCALE);
        Assert.assertNotNull(joke);
        Assert.assertFalse(joke.isEmpty());
    }
}
