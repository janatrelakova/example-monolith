package cz.muni.fi.xtrelak.repository;

import cz.muni.fi.xtrelak.model.Cart;
import cz.muni.fi.xtrelak.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class CartRepository {
    private final ArrayList<Cart> carts = new ArrayList<>(
            new ArrayList<>() {{
                add(new Cart(1, "Cart", new ArrayList<>()));
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

    public void addProduct(int id, int productId) {
        Cart cart = findById(id).orElse(null);
        if (cart == null) {
            throw new IllegalArgumentException("Cart with id " + id + " not found");
        }
        carts.get(carts.indexOf(cart)).getProducts().add(productId);
    }
}