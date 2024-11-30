package cz.muni.fi.xtrelak.dto;

import cz.muni.fi.xtrelak.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDto extends BaseDto {

    private final boolean delivered;
    private final boolean paid;
    private final List<ProductDto> products;

    public OrderDto(int id, String name, boolean delivery, boolean payment, List<ProductDto> products) {
        super(id, name);
        this.delivered = delivery;
        this.paid = payment;
        this.products = products;
    }

    public OrderDto() {
        super(0, "");
        this.delivered = false;
        this.paid = false;
        this.products = new ArrayList<>();
    }

    public boolean isDelivered() {
        return delivered;
    }

    public boolean isPaid() {
        return paid;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public Order toOrderModel() {
        return new Order(
            this.getId(),
            this.getName(),
            null,
            null,
            this.getProducts().stream().map(ProductDto::toProductModel).toList()
        );
    }
}
