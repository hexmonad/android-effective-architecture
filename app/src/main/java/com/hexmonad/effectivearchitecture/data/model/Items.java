package com.hexmonad.effectivearchitecture.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This class describes the list of items fetched from the rest api.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
    @JsonProperty("results")
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }
}
