package com.androidtutorialpoint.androidviewpagerexample;

public class Movie {
    private String id;
    private String Name;
    private String Image;
    private String Image2;
    private String Overview;
    private float Rating;
    private String release_date;

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }



    public String getImage2() {
        return Image2;
    }

    public void setImage2(String image2) {
        Image2 = image2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
