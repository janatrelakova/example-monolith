package cz.muni.fi.xtrelak.service;

import cz.muni.fi.xtrelak.model.Delivery;
import org.springframework.stereotype.Service;


@Service
public class DeliveryService {

    public Delivery createDelivery(int orderId) {
        return new Delivery(orderId, "Delivery for order " + orderId, false);
    }

    public boolean isDelivered(Delivery delivery) {
        return delivery.isDelivered();
    }

    public void deliver(Delivery delivery) {
       delivery.setDelivered(true);
    }
}