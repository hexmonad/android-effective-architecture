package com.hexmonad.effectivearchitecture.data.model;

/**
 * This immutable class describes the Item entity.
 */
public class Item {
    private final String title;

    public Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
