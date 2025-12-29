package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.impl;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmSanPham;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.repository.HqmSanPhamRepository;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.HqmSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HqmSanPhamServiceImpl implements HqmSanPhamService {
    @Autowired
    private HqmSanPhamRepository repo;

    @Override
    public List<HqmSanPham> findAll() { return repo.findAll(); }

    @Override
    public HqmSanPham findById(Integer id) { return repo.findById(id).orElse(null); }

    @Override
    public HqmSanPham save(HqmSanPham sp) { return repo.save(sp); }

    @Override
    public void deleteById(Integer id) { repo.deleteById(id); }

    @Override
    public List<HqmSanPham> findByDanhMuc(Integer maDMSP) { return repo.findByDanhMucMaDMSP(maDMSP); }

    @Override
    public List<HqmSanPham> search(String q) { return repo.findByTenSPContainingIgnoreCase(q); }
}
