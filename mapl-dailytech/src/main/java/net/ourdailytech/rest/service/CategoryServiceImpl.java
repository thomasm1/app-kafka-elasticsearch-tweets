package net.ourdailytech.rest.service;

import net.ourdailytech.rest.exception.ResourceNotFoundException;
import net.ourdailytech.rest.mapper.CategoryMapper;
import net.ourdailytech.rest.models.Category;
import net.ourdailytech.rest.models.dto.CategoryDto;
import net.ourdailytech.rest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category cat3 = categoryMapper.toEntity(categoryDto);
        categoryRepository.save(cat3);

        CategoryDto catNewDto = categoryMapper.toDto(cat3);
        return catNewDto;
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", Long.toString(categoryId)));

        return categoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();
//        List<CategoryDto> categoriesDto = categories.stream().map(category -> categoryMapper.toDto(category))
//                .collect(Collectors.toList());
        List<CategoryDto> catDto = categories.stream().map(categoryMapper::toDto)
                .collect(Collectors.toList());
        return catDto;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto ) {

        Category category = categoryMapper.toEntity(categoryDto);
        Category categoryUpdate = categoryRepository.findById(category.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", Long.toString(category.getId())));

        categoryUpdate.setName(categoryDto.getName());
        categoryUpdate.setDescription(categoryDto.getDescription());
        categoryUpdate.setNews(categoryMapper.toEntity(categoryDto).getNews());

        Category categoryDone = categoryRepository.save(categoryUpdate);

        return categoryMapper.toDto(categoryDone);
    }

    @Override
    public boolean deleteCategory(Long categoryId) {
        try {
            categoryRepository.deleteById(categoryId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
