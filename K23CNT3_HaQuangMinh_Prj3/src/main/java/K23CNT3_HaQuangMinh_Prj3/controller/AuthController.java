package K23CNT3_HaQuangMinh_Prj3.controller;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmUser;
import K23CNT3_HaQuangMinh_Prj3.repository.HqmUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private HqmUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(HqmUser user, Model model) {

        // Mã hóa mật khẩu
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Gán role mặc định
        user.setRole("ROLE_USER");

        // Lưu vào DB
        userRepository.save(user);

        model.addAttribute("success", true);
        return "register";  // Trả về lại trang đăng ký kèm thông báo
    }
}

