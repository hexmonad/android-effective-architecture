package com.hexmonad.effectivearchitecture.di.module;

import android.app.Activity;
import android.content.Context;

import com.hexmonad.effectivearchitecture.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Context provideContext() {
        return activity;
    }

}
