package com.irohal.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    // retrieve all users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // retrieve single user
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable Integer id) {
        final User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id=" + id);
        }
        return user;
    }

    // create new user
    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) {
        final User createdUser = service.saveUser(user);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(createdUser.getId());
        return ResponseEntity.created(location).build();
    }

    // retrieve all user's posts
    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllUsersPosts(@PathVariable Integer id) {
        final User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id=" + id);
        }
        return user.getPosts();
    }

    // retrieve single user's post
    @GetMapping("/users/{userId}/posts/{postId}")
    public Post retrieveUsersPost(@PathVariable Integer userId, @PathVariable Integer postId) {
        final User user = service.findOne(userId);
        if (user == null) {
            throw new UserNotFoundException("id=" + userId);
        }
        final Optional<Post> postOpt = user.getPosts().stream().filter(p -> p.getId().equals(postId)).findFirst();
        if (postOpt.isEmpty()) {
            throw new PostNotFoundException("id=" + postId);
        }
        return postOpt.get();
    }

    // create new users' post
    @PostMapping("/users/{userId}/posts")
    public ResponseEntity createUsersPost(@PathVariable Integer userId, @RequestBody Post post) {
        final User user = service.findOne(userId);
        if (user == null) {
            throw new UserNotFoundException("id=" + userId);
        }
        final Post createdPost = service.savePost(user, post);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{postId}").build(createdPost.getId());
        return ResponseEntity.created(location).build();
    }

}
