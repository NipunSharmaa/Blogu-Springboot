package com.nipun.blogz.blogapp.service;

import com.nipun.blogz.blogapp.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    public CategoryDto createCategory(CategoryDto categoryDto);

    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    void deleteCategory(Integer categoryId);

    CategoryDto getCategory(Integer categpryId);

    List<CategoryDto> getCategories();
}
