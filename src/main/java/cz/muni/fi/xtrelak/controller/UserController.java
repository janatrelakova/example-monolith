package cz.muni.fi.xtrelak.controller;

import cz.muni.fi.xtrelak.dto.OrderDto;
import cz.muni.fi.xtrelak.dto.ProductDto;
import cz.muni.fi.xtrelak.model.User;
import cz.muni.fi.xtrelak.service.OrderService;
import cz.muni.fi.xtrelak.service.ProductService;
import cz.muni.fi.xtrelak.service.UserService;
import cz.muni.fi.xtrelak.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final OrderService orderService;
    private final WishlistService wishlistService;

    public UserController(
            @Autowired UserService userService,
            @Autowired OrderService orderService,
            @Autowired WishlistService wishlistService
            ) {
        this.userService = userService;
        this.orderService = orderService;
        this.wishlistService = wishlistService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        wishlistService.createNewWishlist(user.getId());
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/search")
    public User searchUser(@RequestParam("username") String username) {
        return userService.getUserByName(username);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
        if (id != user.getId()) {
            throw new IllegalArgumentException("Id in path and in body must be the same");
        }
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/orders")
    public List<OrderDto> getUserOrders(@PathVariable("id") int id) {
        var orders = orderService.getOrdersByUserId(id);

        return orders.stream().map(order -> new OrderDto(order.getId(), order.getName(), false, false, List.of())).toList();
    }
}
