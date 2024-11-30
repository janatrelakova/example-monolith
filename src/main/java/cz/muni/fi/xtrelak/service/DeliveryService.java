package cz.muni.fi.xtrelak.service;

import cz.muni.fi.xtrelak.model.Delivery;
import cz.muni.fi.xtrelak.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(@Autowired DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery getDeliveryById(int id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        return delivery.orElse(null);
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery updateDelivery(Delivery delivery) {
        return deliveryRepository.update(delivery);
    }

    public void deleteDelivery(int id) {
        deliveryRepository.deleteById(id);
    }
}