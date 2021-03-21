package com.example.practice;

public class Courses {
    String title;
    String duration;
    int image;

    public Courses(String title, String duration, int image) {
        this.title = title;
        this.duration = duration;
        this.image = image;
    }

    public Courses(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
