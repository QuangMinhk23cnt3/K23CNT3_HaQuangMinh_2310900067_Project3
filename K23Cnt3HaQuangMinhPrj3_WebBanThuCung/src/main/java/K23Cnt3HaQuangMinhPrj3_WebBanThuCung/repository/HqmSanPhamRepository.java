package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.repository;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HqmSanPhamRepository extends JpaRepository<HqmSanPham, Integer> {
    List<HqmSanPham> findByDanhMucMaDMSP(Integer maDMSP);
    List<HqmSanPham> findByTenSPContainingIgnoreCase(String q);
}
