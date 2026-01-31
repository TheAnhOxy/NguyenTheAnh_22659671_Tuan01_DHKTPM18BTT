<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/all.min.css">
    <style>
        .state-badge { border-radius: 20px; padding: 5px 15px; font-size: 0.8rem; }
        .status-NEW { background-color: #e3f2fd; color: #0d47a1; }
        .status-PROCESSING { background-color: #fff3e0; color: #e65100; }
        .status-SHIPPED { background-color: #e8f5e9; color: #1b5e20; }
        .status-CANCELLED { background-color: #ffebee; color: #b71c1c; }
        .card-hover:hover { box-shadow: 0 4px 15px rgba(0,0,0,0.1); transition: 0.3s; }
    </style>
</head>
<body class="bg-light">