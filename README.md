Android Effective Architecture
==============================

This sample project is intended to illustrate best practices in Android development. The project implementation includes the following patterns, frameworks and libraries: MVP (presentation layer), DI (Dagger2), RxJava+RxAndroid, Retrofit, unit tests (JUnit+mockito) and others.

A step by step implementation of each architecture concept can be found in the following branches:

1. [simple-mvp/](https://github.com/hexmonad/android-effective-architecture/tree/simple-mvp) - basic Model-View-Presenter architecture;
2. [restapi-retrofit/](https://github.com/hexmonad/android-effective-architecture/tree/restapi-retrofit) - simple-mvp with a REST API example (Retrofit);
3. [feature-rxjava/](https://github.com/hexmonad/android-effective-architecture/tree/feature-rxjava) - restapi-retrofit with RxJava;
4. [feature-dagger2/](https://github.com/hexmonad/android-effective-architecture/tree/feature-dagger2) - dependency injection implementation example using Dagger2;
5. other new architecture concepts will be coming soon.

Acknowledgements
----------------

This work was inspired by many projects, including the following:
 * [Android-CleanArchitecture](https://github.com/android10/Android-CleanArchitecture) by @android10
 * [Android-Boilerplate](https://github.com/hitherejoe/Android-Boilerplate) by @hitherejoe
 * [qualitymatters](https://github.com/artem-zinnatullin/qualitymatters) by @artem-zinnatullin

