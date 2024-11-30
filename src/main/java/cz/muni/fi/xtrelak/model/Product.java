package cz.muni.fi.xtrelak.model;

import cz.muni.fi.xtrelak.dto.ProductDto;

public class Product extends BaseEntity {
    private final Category category;
    private final Brand brand;

    public Product(int id, String name) {
        super(id, name);
        this.category = null;
        this.brand = null;
    }

    public Product(int id, String name, Category category, Brand brand) {
        super(id, name);
        this.category = category;
        this.brand = brand;
    }

    public ProductDto toProductDto() {
        var category = this.category == null ? null : this.category.toString();
        var brand = this.brand == null ? null : this.brand.toString();
        return new ProductDto(this.getId(), this.getName(), category, brand);
    }
}
