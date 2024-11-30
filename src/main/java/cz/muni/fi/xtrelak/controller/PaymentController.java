package cz.muni.fi.xtrelak.controller;

import cz.muni.fi.xtrelak.model.Payment;
import cz.muni.fi.xtrelak.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(@Autowired PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/{orderId}")
    public void pay(@RequestBody Payment payment, @PathVariable int orderId) {
        paymentService.pay(payment, orderId);
    }
}
