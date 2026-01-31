package com.elearning.nguyentheanh_shopping_tuan02.modal.OrderContext;

import com.elearning.nguyentheanh_shopping_tuan02.cores.OrderState;

public class ShippedState implements OrderState {
    @Override
    public void next(OrderContext ctx) {
        System.out.println("Đơn hàng đã giao thành công. Không có bước tiếp theo.");
        // Có thể để trống hoặc ném Exception nếu cố tình gọi tiếp
    }

    @Override
    public void cancel(OrderContext ctx) {
        System.out.println("Đơn hàng đã giao xong, không thể hủy!");
    }

    @Override
    public String getStatusName() { return "SHIPPED"; }
}