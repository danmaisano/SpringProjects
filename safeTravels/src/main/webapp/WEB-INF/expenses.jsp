<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Safe Travels</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1>Safe Travels</h1>
    
    <!-- Expenses Table -->
    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th>Expense</th>
                <th>Vendor</th>
                <th>Amount</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="expense" items="${expenses}">
                <tr>
                    <td><a href="/expenses/${expense.id}">${expense.name}</a></td>
                    <td>${expense.vendor}</td>
                    <td>${expense.amount}</td>
                    <td>
					    <div class="d-flex">
					        <a href="/expenses/edit/${expense.id}" class="btn btn-warning mr-2">Edit</a>
					        <form action="/expenses/delete/${expense.id}" method="post">
					            <input type="hidden" name="_method" value="delete">
					            <input type="submit" value="Delete" class="btn btn-danger">
					        </form>
					    </div>
					</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <h2 class="text-center mt-4">Add an expense:</h2>
    
    <!-- Expense Form -->
    <div class="mt-5">
        <form:form action="/expenses" method="post" modelAttribute="expense">
            <div class="form-group">
                <form:label path="name" class="form-label">Expense Name:</form:label>
                <form:input path="name" class="form-control" required="true"/>
            </div>

            <div class="form-group">
                <form:label path="vendor" class="form-label">Vendor:</form:label>
                <form:textarea path="vendor" class="form-control" rows="4" required="true"/>
            </div>

            <div class="form-group">
                <form:label path="amount" class="form-label">Amount:</form:label>
                <form:input path="amount" class="form-control" required="true"/>
            </div>

            <div class="form-group">
                <form:label path="description" class="form-label">Description</form:label>
                <form:input type="text-area" path="description" class="form-control" required="true"/>
            </div>

            <div class="form-group text-center">
                <input type="submit" value="Submit" class="btn btn-primary"/>
            </div>
        </form:form>
    </div>
</div>

<!-- Bootstrap JS (optional) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
