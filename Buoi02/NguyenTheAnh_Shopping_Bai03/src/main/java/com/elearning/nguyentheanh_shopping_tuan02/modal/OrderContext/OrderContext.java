package com.elearning.nguyentheanh_shopping_tuan02.modal.OrderContext;


import com.elearning.nguyentheanh_shopping_tuan02.cores.OrderState;
import com.elearning.nguyentheanh_shopping_tuan02.cores.parternCoreImpl.NewState;
import com.elearning.nguyentheanh_shopping_tuan02.cores.parternCoreImpl.ProcessingState;

public class OrderContext {
    private OrderState currentState;

    // Mặc định đơn hàng mới tạo sẽ ở trạng thái NEW
    public OrderContext() {
        this.currentState = new NewState();
    }

    // Constructor để load trạng thái từ Database lên
    public OrderContext(String status) {
        if (status.equals("PROCESSING")) this.currentState = new ProcessingState();
        else if (status.equals("SHIPPED")) this.currentState = new ShippedState();
        else if (status.equals("CANCELLED")) this.currentState = new CancelledState();
        else this.currentState = new NewState();
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }

    public OrderState getState() {
        return currentState;
    }

    // Các hành vi ủy thác cho State xử lý
    public void nextStep() {
        currentState.next(this);
    }

    public void cancelOrder() {
        currentState.cancel(this);
    }
}