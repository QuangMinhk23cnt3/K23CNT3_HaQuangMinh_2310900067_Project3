package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.impl;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmDanhMucSP;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.repository.HqmDanhMucSPRepository;
import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service.HqmDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HqmDanhMucServiceImpl implements HqmDanhMucService {
    @Autowired
    private HqmDanhMucSPRepository repo;

    @Override
    public List<HqmDanhMucSP> findAll() { return repo.findAll(); }

    @Override
    public HqmDanhMucSP findById(Integer id) { return repo.findById(id).orElse(null); }

    @Override
    public HqmDanhMucSP save(HqmDanhMucSP dm) { return repo.save(dm); }

    @Override
    public void delete(Integer id) { repo.deleteById(id); }
}
