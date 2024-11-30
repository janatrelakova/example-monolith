package cz.muni.fi.xtrelak.model;

import cz.muni.fi.xtrelak.dto.ProductDto;

public class Product extends BaseEntity {
    public Product(int id, String name) {
        super(id, name);
    }

    public ProductDto toProductDto() {
        return new ProductDto(this.getId(), this.getName());
    }
}
