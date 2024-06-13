package app.mapl.controllers;

import app.mapl.models.dto.CategoryDto;
import app.mapl.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping(CategoryController.API_CATEGORIES)
public class CategoryController {

    public static final String API_CATEGORIES = "/api/categories";
    public static final String ID = "{id}";
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto savedCategory = categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping(ID)
    public ResponseEntity<Optional<CategoryDto>> getCategory(@PathVariable("id") Long categoryId){
         Optional<CategoryDto> categoryDto = categoryService.getCategory(categoryId);
         return ResponseEntity.ok(categoryDto);
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PutMapping("")
    public ResponseEntity<Optional<CategoryDto>> updateCategory(@RequestBody CategoryDto categoryDto ){
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto ));
    }
    @DeleteMapping(ID)
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(true);
    }
}
