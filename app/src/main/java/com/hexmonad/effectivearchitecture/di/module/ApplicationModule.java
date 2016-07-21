package com.hexmonad.effectivearchitecture.di.module;

import com.hexmonad.effectivearchitecture.data.api.RestApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    RestApi providesRestApi() {
        return RestApi.Factory.createRestApi();
    }

}
