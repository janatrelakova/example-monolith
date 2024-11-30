package cz.muni.fi.xtrelak.repository;

import cz.muni.fi.xtrelak.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class OrderRepository {
    private final ArrayList<Order> orders = new ArrayList<>(
            new ArrayList<>() {{
                add(new Order(1, "Order"));
                add(new Order(2, "Order"));
                add(new Order(3, "Order"));
            }}
    );

    public Order save(Order order) {
        orders.add(order);
        return order;
    }

    public Order update(Order order) {
        for (Order c : orders) {
            if (c.getId() == order.getId()) {
                c.setName(order.getName());
                return c;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        orders.removeIf(order -> order.getId() == id);
    }

    public Optional<Order> findById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    public ArrayList<Order> findAll() {
        return orders;
    }
}