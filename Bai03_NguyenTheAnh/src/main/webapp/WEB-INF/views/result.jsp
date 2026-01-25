<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Kết quả đặt vé</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5 text-center">
    <div class="card p-5 shadow">
        <h1 class="text-success">🎉 Đặt vé thành công!</h1>
        <hr>
        <p class="fs-4">Chế độ xử lý: <strong>${mode == 'mq' ? 'Có RabbitMQ' : 'Đồng bộ (Sync)'}</strong></p>
        <p class="fs-2 text-primary">Thời gian phản hồi API: <strong>${time} ms</strong></p>

        <div class="alert alert-info mt-3">
            ${mode == 'mq' ? 'Hệ thống phản hồi ngay lập tức, Email đang được Worker gửi ở nền.' : 'Hệ thống phải đợi gửi Email xong mới phản hồi.'}
        </div>

        <a href="/" class="btn btn-secondary mt-3">Quay lại trang chủ</a>
    </div>
</div>
</body>
</html>