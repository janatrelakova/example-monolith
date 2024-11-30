package cz.muni.fi.xtrelak.service;

import cz.muni.fi.xtrelak.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeliveryService {

    private final NotificationService notificationService;

    public DeliveryService(@Autowired NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public Delivery createDelivery(int orderId) {
        return new Delivery(orderId, "Delivery for order " + orderId, false);
    }

    public boolean isDelivered(Delivery delivery) {
        return delivery.isDelivered();
    }

    public void deliver(Delivery delivery) {
       delivery.setDelivered(true);
       notificationService.sendNotification("Delivery " + delivery.getId() + " has been delivered");
    }
}