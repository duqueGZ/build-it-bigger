package com.example.android.udacity.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA_KEY = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
    }
}
