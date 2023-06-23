package app.mapl.service;

import app.mapl.models.Category;
import app.mapl.mapper.CategoryMapper;
import app.mapl.dto.CategoryDto;
import app.mapl.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;

import app.mapl.exception.ResourceNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class CategoryServiceJPA implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category cat3 = categoryMapper.toEntity(categoryDto);
        categoryRepository.save(cat3);

        CategoryDto catNewDto = categoryMapper.toDto(cat3);
        return catNewDto;
    }

    @Override
    public Optional<CategoryDto> getCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("", "", "Categoryid: "+ categoryId));

        return Optional.ofNullable(categoryMapper.toDto(category));
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
    public Optional<CategoryDto> updateCategory(CategoryDto categoryDto ) {

        Category category = categoryMapper.toEntity(categoryDto);
        Category categoryUpdate = categoryRepository.findById(category.getId()).orElseThrow(
                () -> new ResourceNotFoundException("", "", "Categoryid: "+ categoryDto.getId()));

        categoryUpdate.setName(categoryDto.getName());
        categoryUpdate.setDescription(categoryDto.getDescription());
        categoryUpdate.setUrls(categoryDto.getUrls());

        Category categoryDone = categoryRepository.save(categoryUpdate);

        return Optional.ofNullable(categoryMapper.toDto(categoryDone));
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
