package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.repository;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HqmAdminRepository extends JpaRepository<HqmAdmin, Integer> {
    Optional<HqmAdmin> findByUsername(String username);
}
