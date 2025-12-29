package K23CNT3_HaQuangMinh_Prj3.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "hqm_products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HqmProduct {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private HqmCategory category;
}
