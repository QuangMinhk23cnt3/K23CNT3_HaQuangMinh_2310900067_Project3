package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.controller;


import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmDanhMucSP;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.repository.HqmDanhMucSPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin/categories")
public class HqmAdminDanhMucController {
    @Autowired
    private HqmDanhMucSPRepository repo;

    @GetMapping
    public String list(Model model){
        model.addAttribute("dms", repo.findAll());
        return "admin/danhmuc/list";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("dm", new HqmDanhMucSP());
        return "admin/danhmuc/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute HqmDanhMucSP dm){
        repo.save(dm);
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("dm", repo.findById(id).orElse(new HqmDanhMucSP()));
        return "admin/danhmuc/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        repo.deleteById(id);
        return "redirect:/admin/categories";
    }
}
