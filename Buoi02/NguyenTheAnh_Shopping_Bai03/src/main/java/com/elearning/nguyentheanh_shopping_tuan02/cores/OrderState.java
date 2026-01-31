package com.elearning.nguyentheanh_shopping_tuan02.cores;

import com.elearning.nguyentheanh_shopping_tuan02.modal.OrderContext.OrderContext;

public interface OrderState {
    void next(OrderContext ctx);
    void cancel(OrderContext ctx);
    String getStatusName();
}