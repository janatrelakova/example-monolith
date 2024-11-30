package cz.muni.fi.xtrelak.controller;

import cz.muni.fi.xtrelak.dto.OrderDto;
import cz.muni.fi.xtrelak.dto.ProductDto;
import cz.muni.fi.xtrelak.model.Order;
import cz.muni.fi.xtrelak.service.DeliveryService;
import cz.muni.fi.xtrelak.service.OrderService;
import cz.muni.fi.xtrelak.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final PaymentService paymentService;
    private final DeliveryService deliveryService;


    public OrderController(
            @Autowired OrderService orderService,
            @Autowired PaymentService paymentService,
            @Autowired DeliveryService deliveryService
    ) {
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto order) {
        var result = orderService.createOrder(order.toOrderModel());
        return new OrderDto(result.getId(), result.getName(), false, false, List.of());
    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable("id") int id) {
        var result = orderService.getOrderById(id);
        if (result == null) {
            return null;
        }

        var isPaid = isPaid(result);
        var isDelivered = isDelivered(result);
        var products = getProductDtos(result);
        return new OrderDto(result.getId(), result.getName(), isDelivered, isPaid, products);
    }

    private boolean isDelivered(Order result) {
        var delivery = result.getDelivery();
        var isDelivered = false;
        if (delivery != null) {
            isDelivered = deliveryService.isDelivered(delivery);
        }
        return isDelivered;
    }

    @GetMapping
    public List<OrderDto> getAllOrders() {
        var result = orderService.getAllOrders();
        var orders = new ArrayList<OrderDto>();
        for (var order : result) {
            var isPaid = isPaid(order);
            var isDelivered = isDelivered(order);
            var products = getProductDtos(order);
            orders.add(new OrderDto(order.getId(), order.getName(), isDelivered, isPaid, products));
        }

        return orders;
    }

    private boolean isPaid(Order order) {
        var payment = order.getPayment();
        var isPaid = false;
        if (payment != null) {
            isPaid = paymentService.isPaid(payment);
        }
        return isPaid;
    }

    @PutMapping("/{id}")
    public OrderDto updateOrder(@PathVariable("id") int id, @RequestBody OrderDto order) {
        if (id != order.getId()) {
            throw new IllegalArgumentException("Id in path and in body must be the same");
        }
        var result = orderService.updateOrder(order.toOrderModel());
        if (result == null) {
            return null;
        }

        var isPaid = isPaid(result);
        var isDelivered = isDelivered(result);
        var products = getProductDtos(result);
        return new OrderDto(result.getId(), result.getName(), isDelivered, isPaid, products);
    }

    private static List<ProductDto> getProductDtos(Order result) {
        return result.getProducts().stream().map(i -> new ProductDto(i.getId(), i.getName())).toList();
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrder(id);
    }

    @PostMapping("/{id}/pay")
    public void payOrder(@PathVariable("id") int id) {
        Order order = getOrderById(id).toOrderModel();
        var payment = paymentService.createPayment(order.getId());
        order.setPayment(payment);
        orderService.updateOrder(order);
    }

    @PostMapping("/{id}/deliver")
    public void deliverOrder(@PathVariable("id") int id) {
        Order order = getOrderById(id).toOrderModel();
        var delivery = deliveryService.createDelivery(order.getId());
        deliveryService.deliver(delivery);
        order.setDelivery(delivery);
        orderService.updateOrder(order);
    }
}
