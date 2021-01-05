package com.kmk.motatawerav2.pojo;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class PostsModel {
    private String user_id;
    private String user_name;
    private String user_picture;

    private String id;
    private String body;
    private String media;

    @ServerTimestamp
    private Date timestamp;

    public PostsModel() {
    }

    public PostsModel(String user_id, String user_name, String user_picture, String id, String body, String media, Date timestamp) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_picture = user_picture;
        this.id = id;
        this.body = body;
        this.media = media;
        this.timestamp = timestamp;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_picture() {
        return user_picture;
    }

    public void setUser_picture(String user_picture) {
        this.user_picture = user_picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
