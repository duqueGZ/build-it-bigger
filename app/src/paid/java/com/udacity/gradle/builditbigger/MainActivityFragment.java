package com.udacity.gradle.builditbigger;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivityFragment extends Fragment {

    private ProgressBar mSpinner;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button tellJokeBtn = (Button) root.findViewById(R.id.tellJokeBtn);
        tellJokeBtn.setOnClickListener(new TellJokeOnClickListener());

        mSpinner=(ProgressBar) root.findViewById(R.id.progressBar);
        setSpinnerStatus(View.GONE);

        return root;
    }

    public void setSpinnerStatus(int status) {
        mSpinner.setVisibility(status);
    }

    private class TellJokeOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ((MainActivity)MainActivityFragment.this.getActivity()).tellJoke();
        }
    }
}
