package com.placeremainder.place.smartTroll.Presenters;

/**
 * Created by Habib on 1/8/19.
 */

public interface ILandingPresenter
        extends ParentPresenter {
    @Override
    void onCreate();



    @Override
    void onResume();

    @Override
    void onPause();



    /**
     * Launch the profile activity
     */
    void launchProfileActivity();

    /**
     * Launch History Activity
     */
    void launchHistoryActivity();

    /**
     * Launch Favorite Activity
     */
    void launchFavoriteActivity();

}

