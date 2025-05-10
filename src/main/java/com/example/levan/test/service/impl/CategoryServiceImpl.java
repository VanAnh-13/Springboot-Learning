package com.example.levan.test.service.impl;

import com.example.levan.test.dto.CategoryDTO;
import com.example.levan.test.entity.Category;
import com.example.levan.test.mapper.CategoryMapper;
import com.example.levan.test.repository.CategoryRepository;
import com.example.levan.test.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryInput) {
        Category category = categoryMapper.toCategoryEntity(categoryInput);
        return categoryMapper.toCategoryDTO(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        return categoryMapper.toListCategoryDTO(categoryRepository.findAll());
    }
}
