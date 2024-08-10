package com.nipun.blogz.blogapp.repository;

import com.nipun.blogz.blogapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
