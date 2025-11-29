package k23cnt3_hqmDay05.controller;

import k23cnt3_hqmDay05.entity.Info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping
public class HomeController {
    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        List<Info> profile = new ArrayList<>();
        // Tạo thông tin profile
        profile.add(new Info(
                "Ha Quang Minh",
                "WM",
                "hqm@gmail.com",
                "https://hqm.com")
        );

        model.addAttribute("hqmPrfile", profile);
        return "profile";
    }
}
