package cz.muni.fi.xtrelak.model;

public class Delivery extends BaseEntity {
    private boolean isDelivered;

    public Delivery(int id, String name, boolean isDelivered) {
        super(id, name);
        this.isDelivered = isDelivered;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }
}
