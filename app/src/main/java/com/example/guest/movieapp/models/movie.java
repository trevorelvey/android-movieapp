package com.example.guest.movieapp.models;

public class Movie {
    private String mTitle;
    private String mDescription;
    private String mReleaseDate;
    private String mRatingAve;
    private String mImageUrl;

    public Movie(String title, String description, String releaseDate, String ratingAve, String imageUrl) {
        this.mTitle = title;
        this.mDescription = description;
        this.mReleaseDate = releaseDate;
        this.mRatingAve = ratingAve;
        this.mImageUrl = imageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getRatingAve() {
        return mRatingAve;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
