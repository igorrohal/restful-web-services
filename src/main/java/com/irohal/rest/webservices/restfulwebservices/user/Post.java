package com.irohal.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class Post {

    private Integer id;
    private String text;
    private Date created;

    public Post(Integer id, String text, Date created) {
        this.id = id;
        this.text = text;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
