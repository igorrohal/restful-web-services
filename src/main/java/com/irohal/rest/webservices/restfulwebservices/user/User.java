package com.irohal.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private Integer id;

    private String name;

    private Date birthDate;

    @JsonIgnore
    private List<Post> posts;

    @JsonIgnore
    private int postsIdGenerator = 1;

    public User(Integer id, String name, Date birthDate) {
        this(id, name, birthDate, new ArrayList<>());
    }

    public User(Integer id, String name, Date birthDate, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getPostsIdGenerator() {
        return postsIdGenerator;
    }

    public void setPostsIdGenerator(int postsIdGenerator) {
        this.postsIdGenerator = postsIdGenerator;
    }

}
