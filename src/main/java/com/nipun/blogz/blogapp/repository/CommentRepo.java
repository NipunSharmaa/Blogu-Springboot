package com.nipun.blogz.blogapp.repository;

import com.nipun.blogz.blogapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
