package cz.muni.fi.xtrelak.repository;

import cz.muni.fi.xtrelak.model.Cart;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class CartRepository {
    private final ArrayList<Cart> carts = new ArrayList<>(
            new ArrayList<>() {{
                add(new Cart(1, "Cart"));
                add(new Cart(2, "Cart"));
                add(new Cart(3, "Cart"));
            }}
    );

    public Cart save(Cart cart) {
        carts.add(cart);
        return cart;
    }

    public Cart update(Cart cart) {
        for (Cart c : carts) {
            if (c.getId() == cart.getId()) {
                c.setName(cart.getName());
                return c;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        carts.removeIf(cart -> cart.getId() == id);
    }

    public Optional<Cart> findById(int id) {
        for (Cart cart : carts) {
            if (cart.getId() == id) {
                return Optional.of(cart);
            }
        }
        return Optional.empty();
    }

    public ArrayList<Cart> findAll() {
        return carts;
    }
}