package cz.muni.fi.xtrelak.repository;

import cz.muni.fi.xtrelak.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class CategoryRepository {
    private final ArrayList<Category> categories = new ArrayList<>(
            new ArrayList<>() {{
                add(new Category(1, "Electronics"));
                add(new Category(2, "Books"));
                add(new Category(3, "Clothing"));
            }}
    );

    public Optional<Category> findById(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return Optional.of(category);
            }
        }
        return Optional.empty();
    }

    public ArrayList<Category> findAll() {
        return categories;
    }
}