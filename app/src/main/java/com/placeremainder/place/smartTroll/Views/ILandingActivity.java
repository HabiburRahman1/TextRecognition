package com.placeremainder.place.smartTroll.Views;

import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Habib on 1/8/19.
 */

public interface ILandingActivity extends IParentView {
    /**
     * Get the reference of a nfc imageview
     *
     * @return ImageView
     */
    ImageView getOpenNFC();

    /**
     * Get the reference of a profile imageview
     *
     * @return ImageView
     */
    Button getProfileButton();

    /**
     * Get the reference of outer circle
     * @return ImageView
     * */
    ImageView getRotator();

    @Override
    Activity getParentActivity();
}
