package cz.muni.fi.xtrelak.dto;

import cz.muni.fi.xtrelak.model.Cart;

import java.util.List;

public class CartDto extends BaseDto {
    private final List<ProductDto> products;

    public CartDto() {
        super(0, "");
        this.products = null;
    }

    public CartDto(int id, String name, List<ProductDto> products) {
        super(id, name);
        this.products = products;
    }

    public Cart toCartModel() {
        if (products == null) {
            return new Cart(this.getId(), this.getName(), List.of());
        }
        return new Cart(this.getId(), this.getName(), products.stream().map(BaseDto::getId).toList());
    }
}
