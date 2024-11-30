package cz.muni.fi.xtrelak.repository;

import cz.muni.fi.xtrelak.model.Delivery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class DeliveryRepository {
    private final ArrayList<Delivery> deliveries = new ArrayList<>(
            new ArrayList<>() {{
                add(new Delivery(1, "Delivery"));
                add(new Delivery(2, "Delivery"));
                add(new Delivery(3, "Delivery"));
            }}
    );

    public Delivery save(Delivery delivery) {
        deliveries.add(delivery);
        return delivery;
    }

    public Delivery update(Delivery delivery) {
        for (Delivery c : deliveries) {
            if (c.getId() == delivery.getId()) {
                c.setName(delivery.getName());
                return c;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        deliveries.removeIf(delivery -> delivery.getId() == id);
    }

    public Optional<Delivery> findById(int id) {
        for (Delivery delivery : deliveries) {
            if (delivery.getId() == id) {
                return Optional.of(delivery);
            }
        }
        return Optional.empty();
    }

    public ArrayList<Delivery> findAll() {
        return deliveries;
    }
}