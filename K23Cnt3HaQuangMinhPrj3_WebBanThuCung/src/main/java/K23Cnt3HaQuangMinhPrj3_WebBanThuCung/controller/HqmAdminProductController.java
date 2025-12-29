package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.controller;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmSanPham;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.repository.HqmDanhMucSPRepository;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.repository.HqmSanPhamRepository;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.util.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/products")
public class HqmAdminProductController {
    @Autowired private HqmSanPhamRepository spRepo;
    @Autowired private HqmDanhMucSPRepository dmRepo;
    @Autowired private FileStorageService fileService;

    @GetMapping
    public String list(Model model){
        model.addAttribute("products", spRepo.findAll());
        return "admin/products/list";
    }

    // 🔴 Đã sửa: Thay "product" bằng "maSP"
    @GetMapping("/create")
    public String createForm(Model model){
        // Thêm đối tượng TttSanPham vào Model với tên "maSP"
        model.addAttribute("maSP", new HqmSanPham());
        model.addAttribute("dms", dmRepo.findAll());
        return "admin/products/form";
    }

    @PostMapping("/save")
    // Lưu ý: @ModelAttribute TttSanPham product vẫn hoạt động tốt,
    // Spring tự động binding dữ liệu từ form vào đối tượng này.
    public String save(@ModelAttribute HqmSanPham product, @RequestParam("imageFile") MultipartFile file){
        try {
            if(file!=null && !file.isEmpty()){
                String filename = fileService.store(file);
                product.setHinhAnh(filename);
            }
            spRepo.save(product);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/products";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        // Thêm đối tượng TttSanPham vào Model với tên "maSP"
        model.addAttribute("maSP", spRepo.findById(id).orElse(new HqmSanPham()));
        model.addAttribute("dms", dmRepo.findAll());
        return "admin/products/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        spRepo.deleteById(id);
        return "redirect:/admin/products";
    }
}
