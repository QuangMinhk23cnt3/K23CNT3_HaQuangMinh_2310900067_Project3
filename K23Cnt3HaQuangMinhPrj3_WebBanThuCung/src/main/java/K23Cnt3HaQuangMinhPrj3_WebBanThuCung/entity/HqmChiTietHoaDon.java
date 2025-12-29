package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chitiethoadon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HqmChiTietHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaCTHD")
    private Integer maCTHD;

    @ManyToOne
    @JoinColumn(name = "MaHD")
    private HqmHoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "MaSP")
    private HqmSanPham sanPham;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Double donGia;
}
