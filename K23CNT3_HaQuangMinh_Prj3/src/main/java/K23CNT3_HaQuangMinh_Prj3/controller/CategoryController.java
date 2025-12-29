package K23CNT3_HaQuangMinh_Prj3.controller;

import K23CNT3_HaQuangMinh_Prj3.repository.HqmCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    private HqmCategoryRepository categoryRepo;

    @GetMapping("/categories")
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "category/list";
    }
}
