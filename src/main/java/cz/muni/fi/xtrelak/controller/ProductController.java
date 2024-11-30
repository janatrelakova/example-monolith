package cz.muni.fi.xtrelak.controller;

import cz.muni.fi.xtrelak.dto.ProductDto;
import cz.muni.fi.xtrelak.model.Product;
import cz.muni.fi.xtrelak.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto product) {
        var result = productService.createProduct(product.toProductModel());
        return result.toProductDto();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable("id") int id) {
        var result = productService.getProductById(id);
        return result.toProductDto();
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        var result = productService.getAllProducts();
        return result.stream().map(Product::toProductDto).toList();
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable("id") int id, @RequestBody ProductDto product) {
        if (id != product.getId()) {
            throw new IllegalArgumentException("Id in path and in body must be the same");
        }
        var result = productService.updateProduct(product.toProductModel());
        return result.toProductDto();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
    }
}
