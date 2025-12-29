package K23CNT3_HaQuangMinh_Prj3.service;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmOrder;

import java.util.List;

public interface OrderService {
    List<HqmOrder> getAll();

    HqmOrder getById(Long id);

    List<HqmOrder> getByUserId(Long userId);

    HqmOrder save(HqmOrder order);

    void updateStatus(Long orderId, String status);

    void delete(Long id);
}
