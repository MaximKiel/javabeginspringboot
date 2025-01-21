package ru.javabegin.todobackend.controller;

import org.springframework.web.bind.annotation.*;
import ru.javabegin.todobackend.entity.Category;
import ru.javabegin.todobackend.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/all")
    public List<Category> findById(@RequestBody String email) {
        return categoryService.findAll(email);
    }
}
