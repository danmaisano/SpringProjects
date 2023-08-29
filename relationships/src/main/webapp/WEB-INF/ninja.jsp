<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add a Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> 
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
    <div class="container mt-5">
        <h1>Add a Ninja</h1>
        <form:form action="/addNinja" method="post" modelAttribute="ninja" class="form">
            <div class="mb-3">
                <form:label path="dojo" class="form-label">Select Dojo</form:label>
                <form:select path="dojo" class="form-select">
                    <form:options items="${allDojos}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
            <div class="mb-3">
                <form:label path="firstName" class="form-label">First Name</form:label>
                <form:input path="firstName" class="form-control"/>
            </div>
            <div class="mb-3">
                <form:label path="lastName" class="form-label">Last Name</form:label>
                <form:input path="lastName" class="form-control"/>
            </div>
            <div class="mb-3">
                <form:label path="age" class="form-label">Age</form:label>
                <form:input path="age" class="form-control"/>
            </div>

            <form:button type="submit" class="btn btn-primary">Submit</form:button>
        </form:form>
    </div>
</body>
</html>
