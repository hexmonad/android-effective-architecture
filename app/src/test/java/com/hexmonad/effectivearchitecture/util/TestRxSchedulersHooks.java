package com.hexmonad.effectivearchitecture.util;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

/**
 * Use this class to register test SchedulerHooks for RxJava and RxAndroid to ensure that
 * subscriptions always subscribeOn and observeOn Schedulers.immediate().
 */
public class TestRxSchedulersHooks {

    private final RxJavaSchedulersHook rxJavaSchedulersHook;
    private final RxAndroidSchedulersHook rxAndroidSchedulersHook;

    public TestRxSchedulersHooks() {
        rxJavaSchedulersHook = new RxJavaSchedulersHook() {
            @Override
            public Scheduler getIOScheduler() {
                return Schedulers.immediate();
            }

            @Override
            public Scheduler getComputationScheduler() {
                return Schedulers.immediate();
            }

            @Override
            public Scheduler getNewThreadScheduler() {
                return Schedulers.immediate();
            }
        };

        rxAndroidSchedulersHook = new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        };
    }

    public void registerHooks() {
        RxJavaPlugins.getInstance().registerSchedulersHook(rxJavaSchedulersHook);
        RxAndroidPlugins.getInstance().registerSchedulersHook(rxAndroidSchedulersHook);
    }

    public void unregisterHooks() {
        RxJavaPlugins.getInstance().reset();
        RxAndroidPlugins.getInstance().reset();
    }
}
