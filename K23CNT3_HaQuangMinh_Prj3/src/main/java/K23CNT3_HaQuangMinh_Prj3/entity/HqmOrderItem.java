package K23CNT3_HaQuangMinh_Prj3.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hqm_order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HqmOrderItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private HqmOrder order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private HqmProduct product;

    private Integer quantity;
    private Double price;
}
