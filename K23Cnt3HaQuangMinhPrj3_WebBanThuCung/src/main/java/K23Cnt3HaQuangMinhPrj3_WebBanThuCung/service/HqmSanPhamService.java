package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmSanPham;

import java.util.List;

public interface HqmSanPhamService {
    List<HqmSanPham> findAll();
    HqmSanPham findById(Integer id);
    HqmSanPham save(HqmSanPham sp);
    void deleteById(Integer id);
    List<HqmSanPham> findByDanhMuc(Integer maDMSP);
    List<HqmSanPham> search(String q);
}
