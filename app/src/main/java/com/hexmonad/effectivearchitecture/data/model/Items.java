package com.hexmonad.effectivearchitecture.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This class describes the list of items fetched from the rest api.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
    private List<Item> items;

    @JsonCreator
    public Items(@JsonProperty("results") List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
