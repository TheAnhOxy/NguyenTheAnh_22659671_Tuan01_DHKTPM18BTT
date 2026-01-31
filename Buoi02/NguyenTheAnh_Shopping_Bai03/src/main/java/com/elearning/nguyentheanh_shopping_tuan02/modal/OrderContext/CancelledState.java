package com.elearning.nguyentheanh_shopping_tuan02.modal.OrderContext;

import com.elearning.nguyentheanh_shopping_tuan02.cores.OrderState;

public class CancelledState implements OrderState {
    @Override
    public void next(OrderContext ctx) {
        System.out.println("Đơn hàng đã bị hủy, không thể tiếp tục xử lý.");
    }

    @Override
    public void cancel(OrderContext ctx) {
        System.out.println("Đơn hàng này đã ở trạng thái hủy rồi.");
    }

    @Override
    public String getStatusName() { return "CANCELLED"; }
}