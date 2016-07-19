package com.hexmonad.effectivearchitecture.data.model;

import android.text.TextUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * This class describes the ItemDetails entity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDetails {
    private int id;
    private String name;
    private int height;
    private int weight;
    private Sprites sprites;
    private List<Type> types;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public List<String> getTypes() {
        List<String> typeList = new ArrayList<>(types.size());
        for (Type type : types) {
            typeList.add(type.type.name);
        }
        return typeList;
    }

    public String getType() {
        return TextUtils.join(" ", getTypes());
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sprites {
        @JsonProperty("back_default") private String backImageUrl;
        @JsonProperty("front_default") private String frontImageUrl;

        public String getBackImageUrl() {
            return backImageUrl;
        }

        public String getFrontImageUrl() {
            return frontImageUrl;
        }
    }

    private static class Type {
        public int slot;
        public Info type;

        private static class Info {
            public String url;
            public String name;
        }
    }

}
