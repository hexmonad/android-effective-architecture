package com.hexmonad.effectivearchitecture.data.api;

import com.hexmonad.effectivearchitecture.data.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * RestApi
 */
public class RestApi {

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>(5);
        items.add(new Item("Item 1"));
        items.add(new Item("Item 2"));
        items.add(new Item("Item 3"));
        items.add(new Item("Item 4"));
        items.add(new Item("Item 5"));
        return items;
    }

}
