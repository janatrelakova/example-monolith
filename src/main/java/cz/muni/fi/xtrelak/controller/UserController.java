package cz.muni.fi.xtrelak.controller;

import cz.muni.fi.xtrelak.dto.OrderDto;
import cz.muni.fi.xtrelak.dto.UserDto;
import cz.muni.fi.xtrelak.service.OrderService;
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
    public UserDto createUser(@RequestBody UserDto user) {
        wishlistService.createNewWishlist(user.getId());
        var result = userService.createUser(user.toUserModel());
        return new UserDto(result.getId(), result.getName());
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") int id) {
        var result = userService.getUserById(id);
        return new UserDto(result.getId(), result.getName());
    }

    @GetMapping("/search")
    public UserDto searchUser(@RequestParam("username") String username) {
        var result = userService.getUserByName(username);
        return new UserDto(result.getId(), result.getName());
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        var result = userService.getAllUsers();
        return result.stream().map(u -> new UserDto(u.getId(), u.getName())).toList();
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable("id") int id, @RequestBody UserDto user) {
        if (id != user.getId()) {
            throw new IllegalArgumentException("Id in path and in body must be the same");
        }
        var result = userService.updateUser(user.toUserModel());
        return new UserDto(result.getId(), result.getName());
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
