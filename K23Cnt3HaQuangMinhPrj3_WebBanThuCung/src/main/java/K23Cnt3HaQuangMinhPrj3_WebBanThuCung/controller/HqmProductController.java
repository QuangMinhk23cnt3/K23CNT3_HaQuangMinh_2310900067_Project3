package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.controller;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmSanPham;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.HqmDanhMucService;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.HqmSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class HqmProductController {
    @Autowired
    private HqmSanPhamService spService;

    @Autowired
    private HqmDanhMucService dmService;

    @GetMapping
    public String list(@RequestParam(required=false) Integer cat, Model model) {
        List<HqmSanPham> list;
        if (cat != null) list = spService.findByDanhMuc(cat);
        else list = spService.findAll();
        model.addAttribute("products", list);
        model.addAttribute("dms", dmService.findAll());
        return "products/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        model.addAttribute("product", spService.findById(id));
        return "products/detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam String q, Model model) {
        model.addAttribute("products", spService.search(q));
        model.addAttribute("dms", dmService.findAll());
        return "products/list";
    }
}
