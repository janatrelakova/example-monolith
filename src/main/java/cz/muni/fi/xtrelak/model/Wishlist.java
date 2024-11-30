package cz.muni.fi.xtrelak.model;

import java.util.List;

public class Wishlist {
    private final int userId;
    private final List<Integer> products;

    public Wishlist(int userId, List<Integer> products) {
        this.userId = userId;
        this.products = products;
    }

    public int getUserId() {
        return userId;
    }

    public List<Integer> getProducts() {
        return products;
    }
}
