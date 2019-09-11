package com.placeremainder.place.smartTroll.Presenters;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ProgressBar;

import com.placeremainder.place.smartTroll.Activities.MainActivity;
import com.placeremainder.place.smartTroll.Views.ILandingActivity;

/**
 * Created by Habib on 1/8/19.
 */

public class LandingPresenterImpl implements ILandingPresenter {
    static final String TAG = LandingPresenterImpl.class.getSimpleName();

    ILandingActivity mLandingView;
    public static int state = 0;
    ProgressBar mProgressbar;

    public LandingPresenterImpl(ILandingActivity view) {
        this.mLandingView = view;
        this.mProgressbar = view.getProgressbar();
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onCreateView() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onResume() {
        hidProgressbar();
        final RotateAnimation rotate = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(2000);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setInterpolator(new LinearInterpolator());

        mLandingView
                .getOpenNFC()
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (state == 0) {
                            mLandingView.getRotator().startAnimation(rotate);
                            state = 1;
                        } else {
                            mLandingView.getRotator().clearAnimation();
                            state = 0;
                        }

                        delayAndStartListActivity();
                    }
                });
        mLandingView
                .getProfileButton()
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showProgressbar();
                        startProfileActivity();
                    }
                });
    }
    private void startProfileActivity() {
        Intent profileIntent = new Intent(mLandingView.getParentActivity(), MainActivity.class);
        mLandingView.getParentActivity().startActivity(profileIntent);
    }
    private void delayAndStartListActivity() {
        final int interval = 1500;
        Handler handler = new Handler();
        Runnable runnable = () -> {
            Intent itemListIntent = new Intent(mLandingView.getParentActivity(), MainActivity.class);
            mLandingView.getParentActivity().startActivity(itemListIntent);
        };
        handler.postAtTime(runnable, System.currentTimeMillis() + interval);
        handler.postDelayed(runnable, interval);
    }

    @Override
    public void onPause() {
        hidProgressbar();
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void launchProfileActivity() {
        hidProgressbar();
        Log.d(TAG, "I got called");

    }

    @Override
    public void launchHistoryActivity() {

    }
    @Override
    public void launchFavoriteActivity() {

    }
    @Override
    public void showProgressbar() {
        if (mProgressbar.getVisibility() == View.GONE) {
            mProgressbar.setVisibility(View.VISIBLE);
        }

    }
    @Override
    public void hidProgressbar() {
        if (mProgressbar.getVisibility() == View.VISIBLE) {
            mProgressbar.setVisibility(View.GONE);
        }
    }
}