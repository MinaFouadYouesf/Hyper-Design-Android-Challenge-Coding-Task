package com.example.mina.minatask.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class productObject implements Parcelable {
    @SerializedName("id")
    private int id;
    @SerializedName("productDescription")
    private String productDescription;
    @SerializedName("image")
    private Image image;
    @SerializedName("price")
    private int price;

    public productObject(int id, String productDescription, Image image, int price) {
        this.id = id;
        this.productDescription = productDescription;
        this.image = image;
        this.price = price;
    }

    protected productObject(Parcel in) {
        id = in.readInt();
        productDescription = in.readString();
        image = in.readParcelable(Image.class.getClassLoader());
        price = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(productDescription);
        dest.writeParcelable(image, flags);
        dest.writeInt(price);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<productObject> CREATOR = new Creator<productObject>() {
        @Override
        public productObject createFromParcel(Parcel in) {
            return new productObject(in);
        }

        @Override
        public productObject[] newArray(int size) {
            return new productObject[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Image getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }
}
