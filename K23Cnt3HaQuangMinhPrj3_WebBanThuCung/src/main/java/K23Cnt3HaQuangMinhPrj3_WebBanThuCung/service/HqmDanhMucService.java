package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmDanhMucSP;

import java.util.List;

public interface HqmDanhMucService {
    List<HqmDanhMucSP> findAll();
    HqmDanhMucSP findById(Integer id);
    HqmDanhMucSP save(HqmDanhMucSP dm);
    void delete(Integer id);
}
