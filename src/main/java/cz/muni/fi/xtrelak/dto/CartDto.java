package cz.muni.fi.xtrelak.dto;

import cz.muni.fi.xtrelak.model.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartDto extends BaseDto {
    private final List<ProductDto> products;

    public CartDto(int id, String name, List<ProductDto> products) {
        super(id, name);
        this.products = products;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public Cart toCartModel() {
        return new Cart(this.getId(), this.getName(), products.stream().map(BaseDto::getId).toList());
    }
}
