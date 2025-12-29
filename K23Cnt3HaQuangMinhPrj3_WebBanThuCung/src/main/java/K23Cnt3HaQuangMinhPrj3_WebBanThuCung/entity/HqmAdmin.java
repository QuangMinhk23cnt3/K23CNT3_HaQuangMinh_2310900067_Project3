package K23Cnt3HaQuangMinhPrj3_WebBanThuCung.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HqmAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaAdmin")
    private Integer maAdmin;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "HoTen")
    private String hoTen;
}
