package K23CNT3_HaQuangMinh_Prj3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";   // templates/index.html
    }

    @GetMapping("/home")
    public String userHome() {
        return "user/home"; // ← KHỚP CÂY THƯ MỤC
    }
}
