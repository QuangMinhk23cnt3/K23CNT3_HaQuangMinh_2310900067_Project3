package K23CNT3_HaQuangMinh_Prj3.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "hqm_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HqmCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
