package K23CNT3_HaQuangMinh_Prj3.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "hqm_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HqmUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String fullName;
    private String phone;
    private String address;

    private String role = "ROLE_USER";
    private boolean enabled = true;
}
