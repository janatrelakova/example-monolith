package cz.muni.fi.xtrelak.service;

import cz.muni.fi.xtrelak.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(@Autowired WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public void createNewWishlist(int userId) {
        wishlistRepository.createNewWishlist(userId);
    }

    public void addProductToWishlist(int userId, int productId) {
        wishlistRepository.addToList(userId, productId);
    }

    public List<Integer> getUserWishlist(int id) {
        return wishlistRepository.getUserWishlist(id);
    }
}
