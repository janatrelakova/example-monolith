package cz.muni.fi.xtrelak.service;

import cz.muni.fi.xtrelak.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final NotificationService notificationService;

    public PaymentService(@Autowired NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public Payment createPayment(int orderId) {
        notificationService.sendNotification("Payment " + orderId + " has been successfully received");
        return new Payment(orderId, "Payment for order " + orderId, true);
    }

    public boolean isPaid(Payment payment) {
        return payment.isPaid();
    }
}
