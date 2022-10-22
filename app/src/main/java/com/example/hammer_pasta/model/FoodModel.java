package com.example.hammer_pasta.model;

public class FoodModel {

    String name;
    String Area;
    String imageUrl;

    public FoodModel(String name, String Area, String imageUrl) {
        this.name = name;
        this.Area = Area;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String description) {
        this.Area = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
