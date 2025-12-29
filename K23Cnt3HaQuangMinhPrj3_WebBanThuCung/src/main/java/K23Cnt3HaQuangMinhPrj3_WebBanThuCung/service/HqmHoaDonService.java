package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.service;

import K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity.HqmHoaDon;

import java.util.List;

public interface HqmHoaDonService {
    List<HqmHoaDon> findAll();
    HqmHoaDon findById(Integer id);
    HqmHoaDon save(HqmHoaDon hd);
}
