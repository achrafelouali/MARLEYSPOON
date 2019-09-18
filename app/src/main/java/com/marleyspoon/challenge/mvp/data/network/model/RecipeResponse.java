package com.marleyspoon.challenge.mvp.data.network.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeResponse {

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("description")
    private String description;

    @Expose
    @SerializedName("photo")
    private String photo;


    @SerializedName("tags")
    @Expose
    private List<Tags> tags;


    @SerializedName("chef")
    @Expose
    private Chef chef;


    public RecipeResponse(String title, String description, String photo, List<Tags> tags, Chef chef) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.tags = tags;
        this.chef = chef;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public static class Tags {
        @Expose
        @SerializedName("name")
        private String name;

        public Tags(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public static class Chef {
        @Expose
        @SerializedName("name")
        private String name;

        public Chef(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


}