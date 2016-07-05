package com.hexmonad.effectivearchitecture.ui.base;

/**
 * Base presenter implementation.
 * The Presenter is a part of the MVP (Model View Presenter) pattern.
 *
 * @param <V> View in terms of the MVP pattern
 */
public class Presenter<V> {

    private V view;

    public void bindView(V view) {
        this.view = view;
    }

    public void unbindView() {
        view = null;
    }

    public V getView() {
        return view;
    }
}
