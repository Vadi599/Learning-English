package com.example.learningenglish.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class CategoryEntity implements Serializable {

    int id;
    int imageResourceId;
    String word_ru;
    String word_en;

   /* public static final Creator<CategoryEntity> CREATOR = new Creator<CategoryEntity>() {
        // распаковываем объект из Parcel
        public CategoryEntity createFromParcel(Parcel in) {
            return new CategoryEntity(in);
        }

        public CategoryEntity[] newArray(int size) {
            return new CategoryEntity[size];
        }
    };*/

    public CategoryEntity(int id, int imageResourceId, String word_ru, String word_en) {
        this.id = id;
        this.imageResourceId = imageResourceId;
        this.word_ru = word_ru;
        this.word_en = word_en;
    }

    public int getId() {
        return id;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getWord_ru() {
        return word_ru;
    }

    public String getWord_en() {
        return word_en;
    }

   /* @Override
    public int describeContents() {
        return 0;
    }*/

   /* @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(imageResourceId);
        dest.writeString(word_ru);
        dest.writeString(word_en);
    }*/

    /*public CategoryEntity(Parcel parcel) {
        id = parcel.readInt();
        imageResourceId = parcel.readInt();
        word_ru = parcel.readString();
        word_en = parcel.readString();
    }*/
}
