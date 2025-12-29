package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.controller;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmKhachHang;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.HqmDanhMucService;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.HqmKhachHangService;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.HqmSanPhamService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class HqmHomeController {
    @Autowired private HqmSanPhamService spService;
    @Autowired private HqmDanhMucService dmService;
    @Autowired private HqmKhachHangService khachHangService;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("products", spService.findAll());
        model.addAttribute("dms", dmService.findAll());
        return "index";
    }

    // ĐĂNG KÝ
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("khachHang", new HqmKhachHang());
        return "user/register"; // CHỈNH SỬA ĐƯỜNG DẪN VIEW
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("khachHang") HqmKhachHang khachHang, Model model, RedirectAttributes redirectAttributes) {
        if (khachHangService.isUsernameExist(khachHang.getUsername())) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
            return "user/register"; // CHỈNH SỬA ĐƯỜNG DẪN VIEW
        }
        try {
            khachHangService.registerKhachHang(khachHang);
            redirectAttributes.addFlashAttribute("success", "Đăng ký thành công! Vui lòng đăng nhập.");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi: " + e.getMessage());
            return "user/register";
        }
    }

    // ĐĂNG NHẬP
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("khachHang", new HqmKhachHang());
        return "user/login"; // CHỈNH SỬA ĐƯỜNG DẪN VIEW
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("khachHang") HqmKhachHang khachHang, HttpSession session, Model model) {
        Optional<HqmKhachHang> authenticatedUser = khachHangService.login(khachHang.getUsername(), khachHang.getPassword());

        if (authenticatedUser.isPresent()) {
            session.setAttribute("user", authenticatedUser.get());
            session.setAttribute("hoTen", authenticatedUser.get().getHoTen());
            return "redirect:/";
        } else {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu.");
            khachHang.setPassword(null);
            return "user/login"; // CHỈNH SỬA ĐƯỜNG DẪN VIEW
        }
    }

    // ĐĂNG XUẤT
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/?logoutSuccess=true";
    }
}
