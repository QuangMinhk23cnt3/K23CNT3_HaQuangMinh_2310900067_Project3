package K23CNT3_HaQuangMinh_Prj3.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "hqm_orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HqmOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private HqmUser user;

    private Double total;
    private String status; // da dat hang, dang chuan bi, da giao, da van chuyen, huy don
    private String paymentMethod;
    private String shippingAddress;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<HqmOrderItem> items;

}
