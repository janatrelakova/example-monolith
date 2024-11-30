package cz.muni.fi.xtrelak.dto;

import cz.muni.fi.xtrelak.model.Delivery;

public class DeliveryDto extends BaseDto {
    private final boolean isDelivered;

    public DeliveryDto(int id, String name, boolean isDelivered) {
        super(id, name);
        this.isDelivered = isDelivered;
    }

    public Delivery toDeliveryModel() {
        return new Delivery(this.getId(), this.getName(), this.isDelivered);
    }
}
