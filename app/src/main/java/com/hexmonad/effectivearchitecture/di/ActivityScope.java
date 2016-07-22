package com.hexmonad.effectivearchitecture.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * This annotation is intended for the ActivityComponent to inform that the objects lifetime
 * provided by this component must correspond to the activity lifecycle.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
