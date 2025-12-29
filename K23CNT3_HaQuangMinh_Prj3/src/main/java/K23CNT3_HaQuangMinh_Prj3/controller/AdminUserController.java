package K23CNT3_HaQuangMinh_Prj3.controller;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmUser;
import K23CNT3_HaQuangMinh_Prj3.repository.HqmUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {

    @Autowired
    private HqmUserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // LIST USERS
    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("user", new HqmUser()); // 🔥 BẮT BUỘC
        return "admin/users";
    }

    // SAVE (ADD + EDIT)
    @PostMapping("/save")
    public String save(@ModelAttribute HqmUser user) {

        // nếu là edit mà không nhập mật khẩu → giữ mật khẩu cũ
        if (user.getId() != null) {
            HqmUser old = userRepo.findById(user.getId()).orElse(null);
            if (old != null && (user.getPassword() == null || user.getPassword().isBlank())) {
                user.setPassword(old.getPassword());
            }
        }

        // mã hóa mật khẩu nếu là user mới
        if (user.getPassword() != null && !user.getPassword().startsWith("$2a$")) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        userRepo.save(user);
        return "redirect:/admin/users";
    }

    // EDIT
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("user", userRepo.findById(id).orElseThrow());
        return "admin/users";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userRepo.deleteById(id);
        return "redirect:/admin/users";
    }
}

