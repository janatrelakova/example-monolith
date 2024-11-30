package cz.muni.fi.xtrelak.controller;

import cz.muni.fi.xtrelak.dto.CartDto;
import cz.muni.fi.xtrelak.model.Product;
import cz.muni.fi.xtrelak.service.CartService;
import cz.muni.fi.xtrelak.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    public CartController(@Autowired CartService cartService, @Autowired ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @PostMapping
    public CartDto createCart(@RequestBody CartDto cart) {
        var result = cartService.createCart(cart.toCartModel());
        var products = productService
                .findAllByIds(result.getProducts())
                .stream().map(Product::toProductDto).toList();
        return new CartDto(result.getId(), result.getName(), products);
    }

    @GetMapping("/{id}")
    public CartDto getCartById(@PathVariable("id") int id) {
        var result = cartService.getCartById(id);
        var products = productService
                .findAllByIds(result.getProducts())
                .stream().map(Product::toProductDto).toList();
        return new CartDto(result.getId(), result.getName(), products);
    }

    @GetMapping
    public List<CartDto> getAllCarts() {
        var carts = cartService.getAllCarts();
        return carts.stream().map(cart -> {
            var products = productService
                    .findAllByIds(cart.getProducts())
                    .stream().map(Product::toProductDto).toList();
            return new CartDto(cart.getId(), cart.getName(), products);
        }).toList();
    }

    @PutMapping("/{id}")
    public CartDto updateCart(@PathVariable("id") int id, @RequestBody CartDto cart) {
        if (id != cart.getId()) {
            throw new IllegalArgumentException("Id in path and in body must be the same");
        }
        var result = cartService.updateCart(cart.toCartModel());
        var products = productService
                .findAllByIds(result.getProducts())
                .stream().map(Product::toProductDto).toList();
        return result.toCartDto(products);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") int id) {
        cartService.deleteCart(id);
    }

    @PostMapping("/{id}/product/{productId}")
    public void addProductToCart(@PathVariable("id") int id, @PathVariable("productId") int productId) {
        cartService.addProductToCart(id, productId);
    }
}
