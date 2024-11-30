package cz.muni.fi.xtrelak.controller;

import cz.muni.fi.xtrelak.model.Cart;
import cz.muni.fi.xtrelak.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(@Autowired CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable int id) {
        return cartService.getCartById(id);
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable int id, @RequestBody Cart cart) {
        if (id != cart.getId()) {
            throw new IllegalArgumentException("Id in path and in body must be the same");
        }
        return cartService.updateCart(cart);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable int id) {
        cartService.deleteCart(id);
    }
}
