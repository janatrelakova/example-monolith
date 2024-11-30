package cz.muni.fi.xtrelak.service;

import cz.muni.fi.xtrelak.model.Product;
import cz.muni.fi.xtrelak.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepository.update(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllByIds(List<Integer> ids) {
        return productRepository.findAllByIds(ids);
    }
}