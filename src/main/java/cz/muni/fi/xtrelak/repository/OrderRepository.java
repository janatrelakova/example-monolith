package cz.muni.fi.xtrelak.repository;

import cz.muni.fi.xtrelak.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderRepository {
    private final ArrayList<Order> orders = new ArrayList<>(
            new ArrayList<>() {{
                add(new Order(1, "Order", null, null, List.of(), 1));
                add(new Order(2, "Order", null, null, List.of(), 2));
                add(new Order(3, "Order", null, null, List.of(), 2));
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
                c.setDelivery(order.getDelivery());
                c.setPayment(order.getPayment());
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

    public List<Order> findByUserId(int userId) {
        return orders.stream().filter(order -> order.getUserId().equals(userId)).toList();
    }
}