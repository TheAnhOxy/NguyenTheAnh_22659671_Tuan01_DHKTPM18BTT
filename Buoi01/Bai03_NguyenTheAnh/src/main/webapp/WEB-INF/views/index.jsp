<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hệ Thống Đặt Vé - RabbitMQ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .card { border-radius: 15px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); }
        .btn-primary { border-radius: 10px; padding: 10px 20px; font-weight: bold; }
        .header-title { color: #0d6efd; font-weight: 800; margin-bottom: 20px; }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card p-4">
                <div class="text-center">
                    <h2 class="header-title">🎟️ HỆ THỐNG ĐẶT VÉ</h2>
                    <p class="text-muted small">Tích hợp RabbitMQ & Email Service</p>
                </div>

                <hr>

                <form action="/order/place" method="post">
                    <div class="mb-3">
                        <label class="form-label fw-bold">Chế độ xử lý (Để so sánh)</label>
                        <div class="d-flex gap-3">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="mode" id="modeMQ" value="mq" checked>
                                <label class="form-check-label" for="modeMQ">Dùng RabbitMQ (Nhanh)</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="mode" id="modeSync" value="sync">
                                <label class="form-check-label" for="modeSync">Không dùng MQ (Chậm)</label>
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label class="form-label fw-bold">Tên khách hàng</label>
                        <input type="text" class="form-control" name="customerName" placeholder="Nhập họ tên..." required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label fw-bold">Email nhận vé</label>
                        <input type="email" class="form-control" name="email" placeholder="example@gmail.com" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label fw-bold">Loại vé đặt</label>
                        <select class="form-select" name="ticketType">
                            <option value="VÉ VIP">✨ VÉ VIP</option>
                            <option value="VÉ THƯỜNG">🎫 VÉ THƯỜNG</option>
                        </select>
                    </div>

                    <div class="d-grid mt-4">
                        <button type="submit" class="btn btn-primary btn-lg">🚀 ĐẶT VÉ NGAY</button>
                    </div>
                </form>

                <div class="mt-3 text-center">
                    <span class="badge bg-success">RabbitMQ: Online</span>
                    <span class="badge bg-info">MariaDB: Connected</span>
                </div>
            </div>

            <p class="text-center mt-3 text-muted" style="font-size: 0.8rem;">
                © 2026 - Nguyễn Thế Anh - Bài Tập Kiến Trúc Phần Mềm
            </p>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>