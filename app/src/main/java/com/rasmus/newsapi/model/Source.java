
package com.rasmus.newsapi.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Source implements Parcelable{

    @SerializedName("id")
    private Object mId;
    @SerializedName("name")
    private String mName;

    public Source(Object mId,String mName) {
//        this.mId = mId;
        this.mName = mName;
    }

    protected Source(Parcel in){
        this.mName = in.readString();
    }

    public static final Creator<Source> CREATOR = new Creator<Source>() {
        @Override
        public Source createFromParcel(Parcel parcel) {
            return new Source(parcel);
        }

        @Override
        public Source[] newArray(int i) {
            return new Source[i];
        }
    };

    public Object getId() {
        return mId;
    }

    public void setId(Object id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
    }
}
