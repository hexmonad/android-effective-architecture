package com.hexmonad.effectivearchitecture.di.module;

import android.app.Application;

import com.hexmonad.effectivearchitecture.data.api.RestApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    RestApi provideRestApi() {
        return RestApi.Factory.createRestApi();
    }

}
