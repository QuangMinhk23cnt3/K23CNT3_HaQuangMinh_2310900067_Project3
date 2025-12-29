
package K23CNT3_HaQuangMinh_Prj3.repository;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HqmProductRepository extends JpaRepository<HqmProduct, Long> {
    List<HqmProduct> findByNameContainingIgnoreCase(String name);

    List<HqmProduct> findByCategoryId(Long categoryId);

    List<HqmProduct> findByPriceBetween(Double min, Double max);
    List<HqmProduct> findTop8ByOrderByIdDesc();
}
