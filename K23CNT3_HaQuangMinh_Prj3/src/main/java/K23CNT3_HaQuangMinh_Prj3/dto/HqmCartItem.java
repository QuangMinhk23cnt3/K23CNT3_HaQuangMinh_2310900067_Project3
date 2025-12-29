package K23CNT3_HaQuangMinh_Prj3.dto;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmProduct;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HqmCartItem {
    private HqmProduct product;
    private int quantity;
}
