package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.udacity.jokedisplay.JokeDisplayActivity;
import com.example.udacity.backend.jokeServerApi.JokeServerApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        Toast.makeText(this, R.string.querying_joke_server, Toast.LENGTH_LONG).show();

        //GCE async task
        new JokeRetrieverAsyncTask().execute(this);
    }

    private class JokeRetrieverAsyncTask extends AsyncTask<Context, Void, String> {
        private JokeServerApi jokeServerApiService = null;
        private Context context;

        @Override
        protected String doInBackground(Context... params) {
            if(jokeServerApiService == null) {  // Only do this once
                JokeServerApi.Builder builder = new JokeServerApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl("https://my-joke-server.appspot.com/_ah/api/");

                jokeServerApiService = builder.build();
            }

            context = params[0];

            try {
                return jokeServerApiService.tellJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(context, R.string.joke_server_answer_received, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, JokeDisplayActivity.class);
            intent.putExtra(JokeDisplayActivity.JOKE_EXTRA_KEY, result);
            startActivity(intent);
        }
    }

}
