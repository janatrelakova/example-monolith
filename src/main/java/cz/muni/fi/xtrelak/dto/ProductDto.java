package cz.muni.fi.xtrelak.dto;

import cz.muni.fi.xtrelak.model.Brand;
import cz.muni.fi.xtrelak.model.Category;
import cz.muni.fi.xtrelak.model.Product;

public class ProductDto extends BaseDto {
    private final String category;
    private final String brand;

    public ProductDto(int id, String name, String category, String brand) {
        super(id, name);
        this.category = category;
        this.brand = brand;
    }

    public ProductDto(int id, String name) {
        super(id, name);
        this.category = "null";
        this.brand = "null1";
    }

    public Product toProductModel() {
        var categoryEnum = Category.valueOf(category);
        var brandEnum = Brand.valueOf(brand);
        return new Product(this.getId(), this.getName(), categoryEnum, brandEnum);
    }
}
