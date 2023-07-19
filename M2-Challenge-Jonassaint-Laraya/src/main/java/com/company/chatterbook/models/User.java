package com.company.chatterbook.models;

import java.util.List;

public class User {

    private String name;

    private List<ChatterPost> chatterPost;

    public User(String name){
        this.name = name;
    }

    public List<ChatterPost> getChatterPost() {
        return chatterPost;
    }

    public void setChatterPosts(List<ChatterPost> chatterPost) {
        this.chatterPost = chatterPost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
