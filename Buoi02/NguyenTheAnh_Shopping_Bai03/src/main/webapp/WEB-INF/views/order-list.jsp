<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hệ thống Quản lý Đơn hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body { background-color: #f8f9fa; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .main-card { border: none; border-radius: 15px; overflow: hidden; }
        .table thead { background-color: #212529; color: white; }
        .status-badge { font-weight: 600; padding: 0.5em 1em; border-radius: 30px; font-size: 0.85rem; text-transform: uppercase; }
        .btn-action { border-radius: 8px; transition: all 0.3s; margin: 0 2px; }
        .btn-action:hover { transform: translateY(-2px); }
        .price-text { color: #0d6efd; font-weight: bold; }
        .tax-badge { background-color: #e9ecef; color: #495057; border: 1px solid #dee2e6; }
    </style>
</head>
<body>

<div class="container py-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <div>
            <h2 class="fw-bold text-dark mb-0">
                <i class="fas fa-boxes-stacked text-primary me-2"></i>Quản lý Đơn hàng
            </h2>
            <p class="text-muted mb-0">Theo dõi trạng thái và áp dụng Design Patterns</p>
        </div>
        <a href="/orders/create" class="btn btn-primary btn-lg shadow-sm">
            <i class="fas fa-plus-circle me-2"></i>Tạo đơn hàng mới
        </a>
    </div>

    <div class="card main-card shadow-sm">
        <div class="card-body p-0">
            <div class="table-responsive">
                <table class="table table-hover align-middle mb-0">
                    <thead class="text-center">
                    <tr>
                        <th class="py-3">ID</th>
                        <th class="py-3 text-start ps-4">Sản phẩm</th>
                        <th class="py-3">Giá gốc</th>
                        <th class="py-3">Thuế (Strategy)</th>
                        <th class="py-3">Thanh toán</th>
                        <th class="py-3">Tổng tiền (Decorator)</th>
                        <th class="py-3">Trạng thái (State)</th>
                        <th class="py-3">Thao tác</th>
                    </tr>
                    </thead>
                    <tbody class="text-center">
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td class="text-muted fw-bold">#${order.id}</td>
                            <td class="text-start ps-4">
                                <span class="d-block fw-bold text-dark">${order.productName}</span>
                                <small class="text-muted">Mã chuẩn SE2026</small>
                            </td>
                            <td>$${order.basePrice}</td>
                            <td>
                                <span class="badge tax-badge">${order.taxType}</span>
                            </td>
                            <td>
                                <i class="fa-brands fa-cc-visa text-secondary me-1"></i> ${order.paymentMethod}
                            </td>
                            <td>
                                <span class="price-text">$${order.finalAmount}</span>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${order.status == 'NEW'}">
                                        <span class="badge status-badge bg-primary-subtle text-primary border border-primary-subtle">Mới tạo</span>
                                    </c:when>
                                    <c:when test="${order.status == 'PROCESSING'}">
                                        <span class="badge status-badge bg-warning-subtle text-warning-emphasis border border-warning-subtle">Đang xử lý</span>
                                    </c:when>
                                    <c:when test="${order.status == 'SHIPPED'}">
                                        <span class="badge status-badge bg-success-subtle text-success border border-success-subtle">Đã giao</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge status-badge bg-danger-subtle text-danger border border-danger-subtle">${order.status}</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <div class="d-flex justify-content-center">
                                    <form action="/orders/advance" method="post">
                                        <input type="hidden" name="orderId" value="${order.id}">
                                        <input type="hidden" name="paymentType" value="${order.paymentMethod}">
                                        <button type="submit" class="btn btn-sm btn-action btn-outline-success"
                                                <c:if test="${order.status == 'SHIPPED' || order.status == 'CANCELLED'}">disabled</c:if>>
                                            <i class="fas fa-arrow-right"></i>
                                        </button>
                                    </form>

                                    <form action="/orders/cancel" method="post">
                                        <input type="hidden" name="orderId" value="${order.id}">
                                        <button type="submit" class="btn btn-sm btn-action btn-outline-warning"
                                                <c:if test="${order.status == 'SHIPPED' || order.status == 'CANCELLED'}">disabled</c:if>>
                                            <i class="fas fa-ban"></i>
                                        </button>
                                    </form>

                                    <form action="/orders/delete" method="post" onsubmit="return confirm('Xóa vĩnh viễn đơn hàng này?');">
                                        <input type="hidden" name="orderId" value="${order.id}">
                                        <button type="submit" class="btn btn-sm btn-action btn-outline-danger">
                                            <i class="fas fa-trash-can"></i>
                                        </button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty orders}">
                        <tr>
                            <td colspan="8" class="py-5 text-muted italic">
                                <i class="fas fa-inbox fa-3x d-block mb-3 opacity-25"></i>
                                Chưa có đơn hàng nào được tạo.
                            </td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>