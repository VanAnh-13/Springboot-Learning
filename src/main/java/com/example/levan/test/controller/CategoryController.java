package com.example.levan.test.controller;

import com.example.levan.test.dto.CategoryDTO;
import com.example.levan.test.response.ApiResponse;
import com.example.levan.test.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category/v1")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ApiResponse<CategoryDTO> createCategory(@RequestParam CategoryDTO categoryDTO) {
        CategoryDTO categoryCreated = categoryService.createCategory(categoryDTO);
        return new ApiResponse<>(HttpStatus.OK.value(), "Category created successfully", categoryCreated);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Category deleted successfully", null);
    }

    @GetMapping
    public ApiResponse<List<CategoryDTO>> getAllCategory() {
        return new ApiResponse<>(HttpStatus.OK.value(), "Category retrieved successfully ", categoryService.getAllCategory());
    }
}
