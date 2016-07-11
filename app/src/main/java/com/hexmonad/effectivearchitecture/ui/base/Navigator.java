package com.hexmonad.effectivearchitecture.ui.base;

import android.content.Context;
import android.content.Intent;

import com.hexmonad.effectivearchitecture.data.model.Item;
import com.hexmonad.effectivearchitecture.ui.detail.DetailActivity;

/**
 * Class used for navigation between app screens.
 */
public class Navigator {

    public static void navigateToDetailPage(Context context, Item item) {
        if (context != null) {
            Intent intentToLaunch = DetailActivity.getCallingIntent(context, item);
            context.startActivity(intentToLaunch);
        }
    }

}
