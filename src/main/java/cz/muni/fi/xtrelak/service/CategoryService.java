package cz.muni.fi.xtrelak.service;

import cz.muni.fi.xtrelak.model.Category;
import cz.muni.fi.xtrelak.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    
    public CategoryService(@Autowired CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}