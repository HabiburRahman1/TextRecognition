package com.placeremainder.place.smartTroll.Views;

import android.app.Activity;
import android.widget.ProgressBar;

/**
 * Created by Habib on 1/8/19.
 */

public interface IParentView {
    /**
     * Get the access of the parent acitivity
     * @return {@link Activity}
     * */
    Activity getParentActivity();
    ProgressBar getProgressbar();
}
