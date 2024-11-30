package cz.muni.fi.xtrelak.repository;

import cz.muni.fi.xtrelak.model.Wishlist;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WishlistRepository {
    private final List<Wishlist> wishlists = new ArrayList<>(
            new ArrayList<>() {{
                add(new Wishlist(1, new ArrayList<>() {{
                    add(1);
                }}));
                add(new Wishlist(1, new ArrayList<>() {{
                    add(1);
                    add(2);
                }}));
                add(new Wishlist(1, new ArrayList<>() {{
                    add(1);
                    add(3);
                }}));
            }}
    );

    public void addToList(Integer userId, Integer productId) {
        var wishlist = wishlists.stream().filter(w -> w.getUserId() == userId).findFirst().orElse(null);
        if (wishlist == null) {
            return;
        }

        wishlist.getProducts().add(productId);
    }

    public void createNewWishlist(int userId) {
        wishlists.add(new Wishlist(userId, new ArrayList<>()));
    }

    public List<Integer> getUserWishlist(int id) {
        var wishlist = wishlists.stream().filter(w -> w.getUserId() == id).findFirst().orElse(null);
        return wishlist == null ? new ArrayList<>() : wishlist.getProducts();
    }
}
