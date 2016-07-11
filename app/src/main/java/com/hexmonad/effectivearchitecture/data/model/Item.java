package com.hexmonad.effectivearchitecture.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This immutable class describes the Item entity.
 */
public class Item implements Parcelable {
    private final String title;

    public Item(String title) {
        this.title = title;
    }

    private Item(Parcel in) {
        title = in.readString();
    }

    public String getTitle() {
        return title;
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
        parcel.writeString(title);
    }
}
