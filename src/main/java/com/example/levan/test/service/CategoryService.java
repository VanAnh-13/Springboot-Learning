package com.example.levan.test.service;

import com.example.levan.test.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryInput);

    void deleteCategory(Long id);

    List<CategoryDTO> getAllCategory();
}
