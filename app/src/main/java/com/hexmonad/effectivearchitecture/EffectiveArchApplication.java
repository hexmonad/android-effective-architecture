/*
 * For the full copyright and license information, please view the LICENSE file that was distributed
 * with this source code. (c) 2016
 */
package com.hexmonad.effectivearchitecture;

import android.app.Application;
import android.content.Context;

import com.hexmonad.effectivearchitecture.di.component.ApplicationComponent;
import com.hexmonad.effectivearchitecture.di.component.DaggerApplicationComponent;
import com.hexmonad.effectivearchitecture.di.module.ApplicationModule;

import timber.log.Timber;

/**
 * EffectiveArchApplication
 */
public class EffectiveArchApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

    }

    public static EffectiveArchApplication get(Context context) {
        return (EffectiveArchApplication) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
