package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import junit.framework.Assert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class JokeServerTest extends ApplicationTestCase<Application> {
    // AsyncTask result
    private String result;
    // A signal to make it possible know when our task is done.
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
        // We will run the test againts a locally deployed GCE server
        final JokeRetrieverAsyncTask taskToTest = new JokeRetrieverAsyncTask(Boolean.TRUE);
        taskToTest.setListener(new JokeRetrieverAsyncTask.JokeRetrieverAsyncTaskListener() {
            @Override
            public void onComplete(String result) {
                JokeServerTest.this.result = result;
                signal.countDown();
            }
        }).execute(getContext());

        /* The testing thread will wait here until the UI thread releases it
         * above with the countDown() call, or 30 seconds passes and it times out.
         */
        signal.await(30, TimeUnit.SECONDS);

        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
    }
}