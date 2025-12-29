package K23CNT3_HaQuangMinh_Prj3.service.impl;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmOrder;
import K23CNT3_HaQuangMinh_Prj3.repository.HqmOrderRepository;
import K23CNT3_HaQuangMinh_Prj3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private HqmOrderRepository orderRepository;

    @Override
    public List<HqmOrder> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public HqmOrder getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<HqmOrder> getByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public HqmOrder save(HqmOrder order) {
        return orderRepository.save(order);
    }

    @Override
    public void updateStatus(Long orderId, String status) {
        HqmOrder order = getById(orderId);
        if (order != null) {
            order.setStatus(status);
            orderRepository.save(order);
        }
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
