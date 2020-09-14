package com.irohal.rest.webservices.restfulwebservices.userjpa;

import com.irohal.rest.webservices.restfulwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
