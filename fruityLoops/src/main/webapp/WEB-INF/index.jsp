<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>FruityLoops</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .custom-container {
            max-width: 30%;
        }

        .custom-border {
            border: 2px solid orange;
        }

        .fruit-row:not(:last-child) {
            border-bottom: 1px solid orange;
            padding-bottom: 10px;
            margin-bottom: 10px;
        }
    </style>
</head>

<body>

<div class="container mt-5 custom-container">
    <h1 class="text-center mb-4">Fruit Store</h1>

    <div class="p-4 custom-border">
        <c:forEach var="fruit" items="${fruits}">
            <div class="row mb-2 fruit-row">
                <div class="col-6">${fruit.name}</div>
                <div class="col-6 text-right">$${fruit.price}</div>
            </div>
        </c:forEach>
    </div>

</div>

<!-- Optional Bootstrap JavaScript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
