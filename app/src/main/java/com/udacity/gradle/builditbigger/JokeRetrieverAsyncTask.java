package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.android.udacity.jokedisplay.JokeDisplayActivity;
import com.example.udacity.backend.jokeServerApi.JokeServerApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by davidduque on 23/01/16.
 */
public class JokeRetrieverAsyncTask extends AsyncTask<Context, Void, String> {
    private static JokeServerApi jokeServerApiService = null;
    private Context context;
    private JokeRetrieverAsyncTaskListener mListener = null;

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

        if (this.mListener != null) {
            this.mListener.onComplete(result);
        }
        Toast.makeText(context, R.string.joke_server_answer_received, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.JOKE_EXTRA_KEY, result);
        context.startActivity(intent);
    }

    public JokeRetrieverAsyncTask setListener(JokeRetrieverAsyncTaskListener listener) {
        this.mListener = listener;
        return this;
    }

    public interface JokeRetrieverAsyncTaskListener {
        void onComplete(String result);
    }
}
