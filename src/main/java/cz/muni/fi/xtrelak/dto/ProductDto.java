package cz.muni.fi.xtrelak.dto;

import cz.muni.fi.xtrelak.model.Product;

public class ProductDto extends BaseDto {
    public ProductDto(int id, String name) {
        super(id, name);
    }

    public Product toProductModel() {
        return new Product(this.getId(), this.getName());
    }
}
