package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hoadon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HqmHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHD")
    private Integer maHD;

    @ManyToOne
    @JoinColumn(name = "MaKH")
    private HqmKhachHang khachHang;

    @Column(name = "NgayLap")
    private java.sql.Date ngayLap;

    @Column(name = "TongTien")
    private Double tongTien;
}
