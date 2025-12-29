package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmKhachHang;

import java.util.List;
import java.util.Optional;

public interface HqmKhachHangService {
    // =============================
    // Phương thức CRUD cơ bản (Giữ nguyên)
    // =============================
    List<HqmKhachHang> findAll();

    // Nên sử dụng Optional cho findById để xử lý trường hợp không tìm thấy
    Optional<HqmKhachHang> findById(Integer id);

    HqmKhachHang save(HqmKhachHang kh);

    void delete(Integer id);

    // =============================
    // Phương thức nghiệp vụ (Authentication/Authorization)
    // =============================

    Optional<HqmKhachHang> login(String username, String password);

    HqmKhachHang registerKhachHang(HqmKhachHang khachHang);

    boolean isUsernameExist(String username);
}
