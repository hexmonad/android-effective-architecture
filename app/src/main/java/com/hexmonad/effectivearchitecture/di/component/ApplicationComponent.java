package com.hexmonad.effectivearchitecture.di.component;

import com.hexmonad.effectivearchitecture.di.module.ApplicationModule;
import com.hexmonad.effectivearchitecture.ui.detail.DetailActivity;
import com.hexmonad.effectivearchitecture.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    // TODO: create ActivityComponent and move inject methods to it
    void inject(MainActivity mainActivity);
    void inject(DetailActivity detailActivity);

}
