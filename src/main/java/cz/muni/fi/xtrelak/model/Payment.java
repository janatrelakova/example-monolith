package cz.muni.fi.xtrelak.model;

public class Payment extends BaseEntity {
    private final boolean isPaid;

    public Payment(int id, String name, boolean isPaid) {
        super(id, name);
        this.isPaid = isPaid;
    }

    public boolean isPaid() {
        return isPaid;
    }
}
