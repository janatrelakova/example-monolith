package cz.muni.fi.xtrelak.repository;

import cz.muni.fi.xtrelak.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class ProductRepository {
    private final ArrayList<Product> products = new ArrayList<>(
            new ArrayList<>() {{
                add(new Product(1, "Product"));
                add(new Product(2, "Product"));
                add(new Product(3, "Product"));
            }}
    );

    public Product save(Product product) {
        products.add(product);
        return product;
    }

    public Product update(Product product) {
        for (Product c : products) {
            if (c.getId() == product.getId()) {
                c.setName(product.getName());
                return c;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    public Optional<Product> findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public ArrayList<Product> findAll() {
        return products;
    }
}