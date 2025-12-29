package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.controller;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.*;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("/checkout")
public class HqmCheckoutController {
    @Autowired private HqmKhachHangRepository khRepo;
    @Autowired private HqmHoaDonRepository hdRepo;
    @Autowired private HqmChiTietHoaDonRepository cthdRepo;
    @Autowired private HqmSanPhamRepository spRepo;

    @PostMapping
    public String checkout(@RequestParam Integer customerId, HttpSession session){
        Map<Integer,Integer> cart = (Map<Integer,Integer>) session.getAttribute("CART");
        if(cart==null || cart.isEmpty()) return "redirect:/cart";

        HqmKhachHang kh = khRepo.findById(customerId).orElse(null);
        if(kh==null) return "redirect:/cart";

        HqmHoaDon hd = new HqmHoaDon();
        hd.setKhachHang(kh);
        hd.setNgayLap(Date.valueOf(LocalDate.now()));
        hd.setTongTien(0.0);
        hd = hdRepo.save(hd);

        double total = 0;
        for(Map.Entry<Integer,Integer> e : cart.entrySet()){
            HqmSanPham sp = spRepo.findById(e.getKey()).orElse(null);
            if(sp==null) continue;
            int qty = e.getValue();
            double price = sp.getGia();
            HqmChiTietHoaDon ct = new HqmChiTietHoaDon();
            ct.setHoaDon(hd);
            ct.setSanPham(sp);
            ct.setSoLuong(qty);
            ct.setDonGia(price);
            cthdRepo.save(ct);
            total += price * qty;
        }
        hd.setTongTien(total);
        hdRepo.save(hd);

        session.removeAttribute("CART");
        return "redirect:/?success";
    }
}
