package com.udacity.gradle.builditbigger;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button tellJokeBtn = (Button) root.findViewById(R.id.tellJokeBtn);
        tellJokeBtn.setOnClickListener(new TellJokeOnClickListener());

        return root;
    }

    private class TellJokeOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ((MainActivity)MainActivityFragment.this.getActivity()).tellJoke();
        }
    }
}
