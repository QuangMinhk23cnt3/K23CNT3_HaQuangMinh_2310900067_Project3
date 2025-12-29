package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.impl;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmHoaDon;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.repository.HqmHoaDonRepository;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.HqmHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HqmHoaDonServiceImpl implements HqmHoaDonService {
    @Autowired
    private HqmHoaDonRepository repo;

    @Override
    public List<HqmHoaDon> findAll() { return repo.findAll(); }

    @Override
    public HqmHoaDon findById(Integer id) { return repo.findById(id).orElse(null); }

    @Override
    public HqmHoaDon save(HqmHoaDon hd) { return repo.save(hd); }
}
