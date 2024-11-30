package cz.muni.fi.xtrelak.controller;

import cz.muni.fi.xtrelak.dto.ProductDto;
import cz.muni.fi.xtrelak.model.Product;
import cz.muni.fi.xtrelak.service.ProductService;
import cz.muni.fi.xtrelak.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;
    private final ProductService productService;

    public WishlistController(
            @Autowired WishlistService wishlistService,
            @Autowired ProductService productService
        ) {
        this.wishlistService = wishlistService;
        this.productService = productService;
    }

    @GetMapping("/{userId}")
    public List<ProductDto> getUserWishlist(@PathVariable("userId") int id) {
        var ids =  wishlistService.getUserWishlist(id);
        var products = productService.findAllByIds(ids);
        return products.stream().map(Product::toProductDto).toList();
    }

    @PostMapping("/{userId}/product/{productId}")
    public void addProductToWishlist(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
        wishlistService.addProductToWishlist(userId, productId);
    }
}
