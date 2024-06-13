package app.mapl.service;

import app.mapl.models.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);

    Optional<CategoryDto> getCategory(Long categoryId);

    List<CategoryDto> getAllCategories();

    Optional<CategoryDto> updateCategory(CategoryDto categoryDto);

    boolean deleteCategory(Long categoryId);
}
