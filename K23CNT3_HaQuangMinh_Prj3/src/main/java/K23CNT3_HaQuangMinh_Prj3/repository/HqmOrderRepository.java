package K23CNT3_HaQuangMinh_Prj3.repository;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HqmOrderRepository extends JpaRepository<HqmOrder, Long> {
    List<HqmOrder> findByUserId(Long userId);
}
