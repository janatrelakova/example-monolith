package cz.muni.fi.xtrelak.dto;

import cz.muni.fi.xtrelak.model.Payment;

public class PaymentDto extends BaseDto {
    private final boolean isPaid;

    public PaymentDto(int id, String name, boolean isPaid) {
        super(id, name);
        this.isPaid = isPaid;
    }

    public Payment toPaymentModel() {
        return new Payment(this.getId(), this.getName(), this.isPaid);
    }
}
