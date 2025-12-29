package K23CNT3_HaQuangMinh_Prj3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String adminHome() {
        return "admin/index"; // template: templates/admin/index.html
    }
}
