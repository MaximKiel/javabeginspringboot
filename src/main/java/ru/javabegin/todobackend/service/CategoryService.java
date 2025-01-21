package ru.javabegin.todobackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javabegin.todobackend.entity.Category;
import ru.javabegin.todobackend.repository.CategoryRepository;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(String email) {
        return repository.findByUserEmailOrderByTitleAsc(email);
    }

    public Category add(Category category) {
        return repository.save(category);
    }
}
