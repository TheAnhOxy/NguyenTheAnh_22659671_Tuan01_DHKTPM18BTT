package com.elearning.nguyentheanh_shopping_tuan02.cores.parternCoreImpl;

import com.elearning.nguyentheanh_shopping_tuan02.cores.OrderState;
import com.elearning.nguyentheanh_shopping_tuan02.modal.OrderContext.CancelledState;
import com.elearning.nguyentheanh_shopping_tuan02.modal.OrderContext.OrderContext;
import com.elearning.nguyentheanh_shopping_tuan02.modal.OrderContext.ShippedState;

public class ProcessingState implements OrderState {
    @Override
    public void next(OrderContext ctx) {
        System.out.println("Đang giao hàng cho đơn vị vận chuyển...");
        ctx.setState(new ShippedState());
    }

    @Override
    public void cancel(OrderContext ctx) {
        System.out.println("Đang xử lý thì không thể hủy trực tiếp! Cần hoàn kho trước.");
        ctx.setState(new CancelledState());
    }

    @Override
    public String getStatusName() { return "PROCESSING"; }
}