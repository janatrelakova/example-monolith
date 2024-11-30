package cz.muni.fi.xtrelak.service;

import cz.muni.fi.xtrelak.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public Payment createPayment(int orderId) {
        return new Payment(orderId, "Payment for order " + orderId, true);
    }

    public boolean isPaid(Payment payment) {
        return payment.isPaid();
    }
}
