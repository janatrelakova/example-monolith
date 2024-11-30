package cz.muni.fi.xtrelak.controller;

import cz.muni.fi.xtrelak.model.Delivery;
import cz.muni.fi.xtrelak.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(@Autowired DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return deliveryService.createDelivery(delivery);
    }

    @GetMapping("/{id}")
    public Delivery getDeliveryById(@PathVariable int id) {
        return deliveryService.getDeliveryById(id);
    }

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @PutMapping("/{id}")
    public Delivery updateDelivery(@PathVariable int id, @RequestBody Delivery delivery) {
        if (id != delivery.getId()) {
            throw new IllegalArgumentException("Id in path and in body must be the same");
        }
        return deliveryService.updateDelivery(delivery);
    }

    @DeleteMapping("/{id}")
    public void deleteDelivery(@PathVariable int id) {
        deliveryService.deleteDelivery(id);
    }
}
