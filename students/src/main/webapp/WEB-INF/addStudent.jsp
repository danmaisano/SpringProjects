<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body class="container mt-5">
    <a href="<%= request.getContextPath() %>/" class="btn btn-primary mb-4">Home</a>

    <h1 class="mb-4">Add a Student</h1>
    <form action="/createStudent" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name:</label>
            <input type="text" id="name" name="name" class="form-control">
        </div>
        <div class="mb-3">
            <label for="dorm" class="form-label">Dorm:</label>
			<select id="dorm" name="dorm" class="form-select">
                <c:forEach var="dorm" items="${allDorms}">
                    <option value="${dorm.id}">${dorm.name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <input type="submit" value="Submit" class="btn btn-success">
        </div>
    </form>
</body>
</html>
