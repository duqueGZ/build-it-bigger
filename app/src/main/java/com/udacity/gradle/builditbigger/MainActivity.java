package com.udacity.gradle.builditbigger;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke() {
        MainActivityFragment fragment = (MainActivityFragment) this.getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        fragment.setSpinnerStatus(View.VISIBLE);

        //GCE async task
        new JokeRetrieverAsyncTask(Boolean.FALSE).execute(this);
    }
}
