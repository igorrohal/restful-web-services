package com.irohal.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
        usersCount = 3;
    }


    public List<User> findAll() {
        return users;
    }

    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(Integer id) {
        for (User user : users) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public Post savePost(User user, Post post) {
        post.setId(user.getPostsIdGenerator());
        post.setCreated(new Date());
        user.setPostsIdGenerator(user.getPostsIdGenerator() + 1);
        user.getPosts().add(post);
        return post;
    }

}
