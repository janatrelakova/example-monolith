package cz.muni.fi.xtrelak.model;

import cz.muni.fi.xtrelak.dto.CartDto;
import cz.muni.fi.xtrelak.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

public class Cart extends BaseEntity {
    private final List<Integer> products;

    public Cart(int id, String name) {
        super(id, name);
        this.products = new ArrayList<>();
    }

    public Cart(int id, String name, List<Integer> products) {
        super(id, name);
        this.products = new ArrayList<>();
    }

    public List<Integer> getProducts() {
        return products;
    }

    public CartDto toCartDto(List<ProductDto> products) {
        return new CartDto(this.getId(), this.getName(), products);
    }
}
