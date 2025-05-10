package com.example.levan.test.mapper;

import com.example.levan.test.dto.CategoryDTO;
import com.example.levan.test.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO toCategoryDTO(Category category);

    Category toCategoryEntity(CategoryDTO categoryDTO);

    List<CategoryDTO> toListCategoryDTO(List<Category> categories);
}
