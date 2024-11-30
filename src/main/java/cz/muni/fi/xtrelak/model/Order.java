package cz.muni.fi.xtrelak.model;

import java.util.List;

public class Order extends BaseEntity {

    private Delivery delivery;
    private Payment payment;
    private final List<Product> products;
    private final Integer userId;

    public Order(int id, String name, Delivery delivery, Payment payment, List<Product> products, Integer userId) {
        super(id, name);
        this.delivery = delivery;
        this.payment = payment;
        this.products = products;
        this.userId = userId;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Integer getUserId() {
        return userId;
    }
}
