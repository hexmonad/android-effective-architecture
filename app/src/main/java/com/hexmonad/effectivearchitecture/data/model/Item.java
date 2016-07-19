package com.hexmonad.effectivearchitecture.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hexmonad.effectivearchitecture.data.api.RestApi;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This immutable class describes the Item entity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements Parcelable {
    private final int id;
    private final String name;
    private final String imageUrl;

    @JsonCreator
    public Item(@JsonProperty("name") String name, @JsonProperty("url") String url) {
        this.name = name;
        this.id = parseItemId(url);
        this.imageUrl = String.format(Locale.US, RestApi.IMAGE_PREVIEW_URL, id);
    }

    private Item(Parcel in) {
        id = in.readInt();
        name = in.readString();
        imageUrl = in.readString();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(imageUrl);
    }

    private int parseItemId(String url) {
        Pattern pattern = Pattern.compile("/(\\d+)/$");
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }
}
