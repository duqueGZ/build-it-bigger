package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;

import junit.framework.Assert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class JokeServerTest extends ApplicationTestCase<Application> {
    // AsyncTask result
    private String result;
    // A signal to let us know when our task is done.
    private CountDownLatch signal;

    public JokeServerTest() {
        super(Application.class);
    }
    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
        result = null;
    }

    public void testJokeFromServer() throws InterruptedException {

        final JokeRetrieverAsyncTask taskToTest = new JokeRetrieverAsyncTask();
        taskToTest.setListener(new JokeRetrieverAsyncTask.JokeRetrieverAsyncTaskListener() {
            @Override
            public void onComplete(String result) {
                JokeServerTest.this.result = result;
                signal.countDown();
            }
        }).execute(getContext());

        /* The testing thread will wait here until the UI thread releases it
         * above with the countDown() or 30 seconds passes and it times out.
         */
        signal.await(30, TimeUnit.SECONDS);

        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
    }
}