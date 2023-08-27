<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Expense</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1>Edit Expense</h1>
        <div class="mt-5">
            <form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
                <input type="hidden" name="_method" value="put" />
                <div class="form-group">
                    <form:label path="name" class="form-label">Expense Name:</form:label>
                    <form:input path="name" class="form-control" required="true"/>
                    <form:errors path="name" cssClass="text-danger"/> <!-- do we need custom error messaging? -->
                </div>

                <div class="form-group">
                    <form:label path="vendor" class="form-label">Vendor:</form:label>
                    <form:textarea path="vendor" class="form-control" rows="4" required="true"/>
                    <form:errors path="vendor" cssClass="text-danger"/>
                </div>

                <div class="form-group">
                    <form:label path="amount" class="form-label">Amount:</form:label>
                    <form:input path="amount" class="form-control" required="true"/>
                    <form:errors path="amount" cssClass="text-danger"/>
                </div>

                <div class="form-group">
                    <form:label path="description" class="form-label">Description:</form:label>
                    <form:input type="text-area" path="description" class="form-control" required="true"/>
                    <form:errors path="description" cssClass="text-danger"/>
                </div>

                <div class="form-group text-center">
                    <input type="submit" value="Update" class="btn btn-primary mr-2"/>
					<a href="/expenses" class="btn btn-warning ml-2">Go Home</a>
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
