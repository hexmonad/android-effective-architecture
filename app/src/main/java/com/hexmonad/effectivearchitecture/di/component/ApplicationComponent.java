package com.hexmonad.effectivearchitecture.di.component;

import com.hexmonad.effectivearchitecture.data.api.RestApi;
import com.hexmonad.effectivearchitecture.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    // list here methods to provide dependencies to other components (~ public dependencies)

    RestApi restApi();

}
