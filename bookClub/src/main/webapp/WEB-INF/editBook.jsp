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
    <title>Edit ${updatedBook.title}</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>Change your Entry for ${updatedBook.title}</h1>
        <form:form action="/editBook" method="POST" modelAttribute="updatedBook">
            <form:hidden path="id"/>
            <div class="form-group">
                <label for="title">Title:</label>
                <form:input path="title" id="title" class="form-control"/>
                <form:errors path="title" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <label for="author">Author:</label>
                <form:input path="author" id="author" class="form-control"/>
                <form:errors path="author" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <label for="thoughts">Thoughts:</label>
                <form:textarea path="thoughts" id="thoughts" class="form-control"/>
                <form:errors path="thoughts" cssClass="text-danger"/>
            </div>  
            <button type="submit" class="btn btn-primary">Update Book</button>
            <a href="/dashboard" class="btn btn-danger mx-5">Go Home</a>
        </form:form>
    </div>
</body>
</html>
