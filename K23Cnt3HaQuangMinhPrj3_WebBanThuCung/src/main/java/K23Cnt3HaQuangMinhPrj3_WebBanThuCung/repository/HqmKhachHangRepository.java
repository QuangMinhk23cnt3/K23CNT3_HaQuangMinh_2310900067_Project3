package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.repository;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmKhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HqmKhachHangRepository extends JpaRepository<HqmKhachHang, Integer> {
    Optional<HqmKhachHang> findByUsername(String username);
}
