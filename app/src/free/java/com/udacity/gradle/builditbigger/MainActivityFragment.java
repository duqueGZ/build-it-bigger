package com.udacity.gradle.builditbigger;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.lang.Override;

public class MainActivityFragment extends Fragment {


    private InterstitialAd mInterstitial;
    private ProgressBar mSpinner;

    public MainActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();

        //Load a new interstitial ad
        mInterstitial = new InterstitialAd(getActivity());
        mInterstitial.setAdUnitId(getActivity().getString(R.string.interstitial_ad_unit_id));
        mInterstitial.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                // If ad failed to load, we directly show the joke display activity
                ((MainActivity) MainActivityFragment.this.getActivity()).tellJoke();
            }

            @Override
            public void onAdClosed() {
                // When ad is closed, we show the joke display activity
                ((MainActivity) MainActivityFragment.this.getActivity()).tellJoke();
            }
        });
        AdRequest ar = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitial.loadAd(ar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button tellJokeBtn = (Button) root.findViewById(R.id.tellJokeBtn);
        tellJokeBtn.setOnClickListener(new TellJokeOnClickListener());

        mSpinner=(ProgressBar) root.findViewById(R.id.progressBar);
        setSpinnerStatus(View.GONE);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        return root;
    }

    public void setSpinnerStatus(int status) {
        mSpinner.setVisibility(status);
    }

    private class TellJokeOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            if (mInterstitial.isLoaded()) {
                mInterstitial.show();
            } else {
                // If ad is not loaded when the user asks for a joke, we directly show the joke
                // display activity, in order to avoid extra waiting time
                ((MainActivity)MainActivityFragment.this.getActivity()).tellJoke();
            }
        }
    }
}