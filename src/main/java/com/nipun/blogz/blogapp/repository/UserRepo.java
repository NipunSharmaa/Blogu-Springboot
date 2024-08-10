package com.nipun.blogz.blogapp.repository;

import com.nipun.blogz.blogapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
