package com.nipun.blogz.blogapp.repository;

import com.nipun.blogz.blogapp.entity.Category;
import com.nipun.blogz.blogapp.entity.Post;
import com.nipun.blogz.blogapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}
