package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.controller;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmKhachHang;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.repository.HqmKhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/khach-hang")
public class HqmKhachHangController {

    @Autowired
    private HqmKhachHangRepository repo;

    // Hiển thị danh sách khách hàng
    @GetMapping("")
    public String list(Model model) {
        List<HqmKhachHang> dsKhachHang = repo.findAll();
        // Tên biến "listKH" phải khớp tuyệt đối với ${listKH} trong HTML
        model.addAttribute("listKH", dsKhachHang);
        return "admin/danhmuc/list";
    }

    // Mở form thêm mới
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("khachhang", new HqmKhachHang());
        return "admin/danhmuc/form";
    }

    // Lưu dữ liệu (Thêm mới & Cập nhật)
    @PostMapping("/save")
    public String save(@ModelAttribute("khachhang") HqmKhachHang kh) {
        try {
            repo.save(kh);
            // PHẢI có dấu "/" ở đầu để redirect về đúng gốc danh sách
            return "redirect:/admin/khach-hang";
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi ra console nếu lưu thất bại
            return "admin/danhmuc/form";
        }
    }

    // Sửa khách hàng
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, Model model) {
        HqmKhachHang kh = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID sai"));
        model.addAttribute("khachhang", kh);
        return "admin/danhmuc/form";
    }

    // Xóa khách hàng
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        repo.deleteById(id);
        return "redirect:/admin/khach-hang";
    }
}