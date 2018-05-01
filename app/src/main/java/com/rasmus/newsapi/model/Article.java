
package com.rasmus.newsapi.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Article implements Parcelable{

    @SerializedName("author")
    private String mAuthor;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("publishedAt")
    private String mPublishedAt;
    @SerializedName("source")
    private Source mSource;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("urlToImage")
    private String mUrlToImage;

    public Article(String mAuthor, String mDescription, String mPublishedAt, Source mSource, String mTitle, String mUrl, String mUrlToImage) {
        this.mAuthor = mAuthor;
        this.mDescription = mDescription;
        this.mPublishedAt = mPublishedAt;
//        this.mSource = mSource;
        this.mTitle = mTitle;
        this.mUrl = mUrl;
        this.mUrlToImage = mUrlToImage;
    }

    protected Article(Parcel in){
        this.mAuthor = in.readString();
        this.mDescription = in.readString();
        this.mPublishedAt = in.readString();
        this.mTitle = in.readString();
        this.mUrl = in.readString();
        this.mUrlToImage = in.readString();
//        this.mSource = in.readParcelable(Source.class.getClassLoader());
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel parcel) {
            return new Article(parcel);
        }

        @Override
        public Article[] newArray(int i) {
            return new Article[i];
        }
    };

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getPublishedAt() {
        return mPublishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        mPublishedAt = publishedAt;
    }

    public Source getSource() {
        return mSource;
    }

    public void setSource(Source source) {
        mSource = source;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getUrlToImage() {
        return mUrlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        mUrlToImage = urlToImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(mAuthor);
        parcel.writeString(mDescription);
        parcel.writeString(mPublishedAt);
        parcel.writeString(mTitle);
        parcel.writeString(mUrl);
        parcel.writeString(mUrlToImage);
//        parcel.writeParcelable(mSource,i);

    }
}
