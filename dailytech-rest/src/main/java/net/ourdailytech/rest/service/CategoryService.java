package net.ourdailytech.rest.service;


import net.ourdailytech.rest.models.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto getCategory(Long categoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(CategoryDto categoryDto);

    boolean deleteCategory(Long categoryId);
}
