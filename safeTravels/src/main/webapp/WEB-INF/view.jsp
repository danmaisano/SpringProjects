<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Expense Details</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1>Expense Details</h1>
        <div class="mt-5">
            <table class="table table-striped">
                <tbody>
                    <tr>
                        <td>Name</td>
                        <td>${expense.name}</td>
                    </tr>
                    <tr>
                        <td>Vendor</td>
                        <td>${expense.vendor}</td>
                    </tr>
                    <tr>
                        <td>Amount</td>
                        <td>${expense.amount}</td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>${expense.description}</td>
                    </tr>

                </tbody>
            </table>
            <a href="/expenses" class="btn btn-primary">Go Back</a>
        </div>
    </div>

    <!-- Bootstrap JS (optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
