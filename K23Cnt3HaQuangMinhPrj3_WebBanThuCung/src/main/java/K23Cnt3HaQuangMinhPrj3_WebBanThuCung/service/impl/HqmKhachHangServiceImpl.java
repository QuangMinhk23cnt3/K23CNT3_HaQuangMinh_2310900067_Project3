package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.impl;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmKhachHang;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.repository.HqmKhachHangRepository;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.HqmKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HqmKhachHangServiceImpl implements HqmKhachHangService {
    @Autowired
    private HqmKhachHangRepository repo;

    // =======================================================
    // Phương thức CRUD cơ bản
    // =======================================================

    @Override
    public List<HqmKhachHang> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<HqmKhachHang> findById(Integer id) {
        // Thay vì .orElse(null), trả về Optional để thống nhất với Interface
        return repo.findById(id);
    }

    @Override
    public HqmKhachHang save(HqmKhachHang kh) {
        return repo.save(kh);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    // =======================================================
    // Phương thức nghiệp vụ (Đăng ký/Đăng nhập)
    // =======================================================

    @Override
    public HqmKhachHang registerKhachHang(HqmKhachHang khachHang) {
        // Trong môi trường phát triển: chỉ cần lưu
        // TODO: Trong thực tế, bạn sẽ mã hóa mật khẩu ở đây trước khi lưu!
        return repo.save(khachHang);
    }

    @Override
    public boolean isUsernameExist(String username) {
        // Kiểm tra xem Repository có tìm thấy username đó không
        return repo.findByUsername(username).isPresent();
    }

    @Override
    public Optional<HqmKhachHang> login(String username, String password) {
        // 1. Tìm kiếm khách hàng bằng username
        Optional<HqmKhachHang> khachHangOpt = repo.findByUsername(username);

        if (khachHangOpt.isPresent()) {
            HqmKhachHang kh = khachHangOpt.get();

            // 2. So sánh mật khẩu
            // Lưu ý: Hiện tại là so sánh chuỗi trần vì DB của bạn lưu mật khẩu trần ('123456')
            // Khi dùng BCryptPasswordEncoder, logic sẽ là:
            // if (passwordEncoder.matches(password, kh.getPassword()))

            if (kh.getPassword().equals(password)) {
                return khachHangOpt; // Đăng nhập thành công
            }
        }

        return Optional.empty(); // Đăng nhập thất bại (Không tìm thấy user hoặc sai password)
    }
}
