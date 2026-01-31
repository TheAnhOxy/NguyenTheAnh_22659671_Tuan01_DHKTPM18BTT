package com.elearning.nguyentheanh_shopping_tuan02.cores.parternCoreImpl;

import com.elearning.nguyentheanh_shopping_tuan02.cores.OrderState;
import com.elearning.nguyentheanh_shopping_tuan02.modal.OrderContext.CancelledState;
import com.elearning.nguyentheanh_shopping_tuan02.modal.OrderContext.OrderContext;

// 1. Trạng thái MỚI TẠO
public class NewState implements OrderState {
    @Override
    public void next(OrderContext ctx) {
        System.out.println("Kiểm tra thông tin... Đang chuyển sang Đóng gói.");
        ctx.setState(new ProcessingState());
    }

    @Override
    public void cancel(OrderContext ctx) {
        System.out.println("Hủy đơn hàng thành công.");
        ctx.setState(new CancelledState());
    }

    @Override
    public String getStatusName() { return "NEW"; }
}

// 2. Trạng thái ĐANG XỬ LÝ
