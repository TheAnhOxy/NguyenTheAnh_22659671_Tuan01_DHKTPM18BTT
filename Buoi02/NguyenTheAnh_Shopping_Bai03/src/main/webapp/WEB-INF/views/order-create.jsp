<%@ include file="../common/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container mt-5">
    <div class="card shadow-sm border-0 mx-auto" style="max-width: 600px;">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0"><i class="fas fa-plus-circle me-2"></i>Tạo Đơn Hàng Mới</h4>
        </div>
        <div class="card-body p-4">
            <form action="/orders/save" method="post">
                <div class="mb-3">
                    <label class="form-label">Tên sản phẩm</label>
                    <input type="text" name="productName" class="form-control" placeholder="Nhập tên sản phẩm..." required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Giá gốc ($)</label>
                    <input type="number" name="basePrice" class="form-control" step="0.01" required>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Loại Thuế (Strategy)</label>
                        <select name="taxType" class="form-select">
                            <option value="VAT">VAT (10%)</option>
                            <option value="LUXURY">Luxury (30%)</option>
                        </select>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Thanh toán</label>
                        <select name="paymentMethod" class="form-select">
                            <option value="PAYPAL">PayPal</option>
                            <option value="CREDIT_CARD">Credit Card</option>
                        </select>
                    </div>
                </div>

                <div class="d-grid gap-2 mt-4">
                    <button type="submit" class="btn btn-success btn-lg">Xác nhận đặt hàng</button>
                    <a href="/orders/list" class="btn btn-light">Quay lại danh sách</a>
                </div>
            </form>
        </div>
    </div>
</div>