package K23CNT3_HaQuangMinh_Prj3.repository;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HqmCategoryRepository extends JpaRepository<HqmCategory, Long> {
    Optional<HqmCategory> findByName(String name);

    boolean existsByName(String name);
}
