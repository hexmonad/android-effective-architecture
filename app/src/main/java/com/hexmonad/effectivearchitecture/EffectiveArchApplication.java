/*
 * For the full copyright and license information, please view the LICENSE file that was distributed
 * with this source code. (c) 2016
 */
package com.hexmonad.effectivearchitecture;

import android.app.Application;
import android.content.Context;

import com.hexmonad.effectivearchitecture.data.api.RestApi;

import timber.log.Timber;

/**
 * EffectiveArchApplication
 */
public class EffectiveArchApplication extends Application {

    private RestApi restApi;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        restApi = RestApi.Factory.createRestApi();
    }

    public static EffectiveArchApplication get(Context context) {
        return (EffectiveArchApplication) context.getApplicationContext();
    }

    public RestApi getRestApi() {
        return restApi;
    }

}
