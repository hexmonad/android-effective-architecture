package com.hexmonad.effectivearchitecture.di.component;

import com.hexmonad.effectivearchitecture.di.ActivityScope;
import com.hexmonad.effectivearchitecture.di.module.ActivityModule;
import com.hexmonad.effectivearchitecture.ui.detail.DetailActivity;
import com.hexmonad.effectivearchitecture.ui.main.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
    void inject(DetailActivity detailActivity);

}
