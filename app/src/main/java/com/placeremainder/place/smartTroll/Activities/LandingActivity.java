package com.placeremainder.place.smartTroll.Activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.placeremainder.place.smartTroll.Presenters.ILandingPresenter;
import com.placeremainder.place.smartTroll.Presenters.LandingPresenterImpl;
import com.placeremainder.place.smartTroll.R;
import com.placeremainder.place.smartTroll.Views.ILandingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LandingActivity extends TransparentStatusBarActivity implements ILandingActivity {
    @BindView(R.id.open_nfc)
    ImageView openNfc;

    @BindView(R.id.profile_icon)
    Button profile;
    @BindView(R.id.image)
    ImageView imgRotator;

    ILandingPresenter presenter;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);
        presenter = new LandingPresenterImpl(this);
        presenter.onCreate();
    }
    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public ImageView getOpenNFC() {
        return openNfc;
    }

    @Override
    public Button getProfileButton() {
        return profile;
    }

    @Override
    public ImageView getRotator() {
        return imgRotator;
    }

    @Override
    public Activity getParentActivity() {
        return LandingActivity.this;
    }

    @Override
    public ProgressBar getProgressbar() {
        return mProgressbar;
    }
}
