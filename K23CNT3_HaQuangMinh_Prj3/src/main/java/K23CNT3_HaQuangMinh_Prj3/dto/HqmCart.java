package K23CNT3_HaQuangMinh_Prj3.dto;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HqmCart {
    private List<HqmCartItem> items = new ArrayList<>();

    /* ========================
       THÊM SP VÀO GIỎ
       ======================== */
    public void addItem(HqmCartItem newItem) {
        for (HqmCartItem item : items) {
            if (item.getProduct().getId()
                    .equals(newItem.getProduct().getId())) {

                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                return;
            }
        }
        items.add(newItem);
    }

    /* ========================
       CẬP NHẬT SỐ LƯỢNG
       ======================== */
    public void updateItem(Long productId, int quantity) {
        for (HqmCartItem item : items) {
            if (item.getProduct().getId().equals(productId)) {
                item.setQuantity(quantity);
                return;
            }
        }
    }

    /* ========================
       XÓA 1 SP
       ======================== */
    public void removeItem(Long productId) {
        items.removeIf(item ->
                item.getProduct().getId().equals(productId));
    }

    /* ========================
       CLEAR GIỎ
       ======================== */
    public void clear() {
        items.clear();
    }

    /* ========================
       TÍNH TỔNG TIỀN
       ======================== */
    public double getTotal() {
        double total = 0;
        for (HqmCartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }
}
