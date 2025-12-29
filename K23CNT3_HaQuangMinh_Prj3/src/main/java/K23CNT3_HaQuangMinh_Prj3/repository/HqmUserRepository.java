package K23CNT3_HaQuangMinh_Prj3.repository;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HqmUserRepository extends JpaRepository<HqmUser, Long> {

    Optional<HqmUser> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);  // 🔥 THÊM DÒNG NÀY
}
