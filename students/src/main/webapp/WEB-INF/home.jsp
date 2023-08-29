<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <title>Dorms</title>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Dorms</h1>
        <nav class="mb-3">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="/addStudent">Add a student</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/newDorm">Add a dorm</a>
                </li>
            </ul>
        </nav>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">Dorm</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dorm" items="${dorms}">
                    <tr>
                        <td>${dorm.name}</td>
                        <td><a href="/showDorm/${dorm.id}">See Students</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
