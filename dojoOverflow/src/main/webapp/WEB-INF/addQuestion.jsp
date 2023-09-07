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
	    <title>New Question</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

	</head>
	<body>
    <div class="container">
    <h1>What is your question?</h1>
    <a href="/dashboard" class="mb-5 h4">Return to Dashboard</a>

        <form action="/addQuestion" method="post">
            <div class="form-group mt-5">
                <label for="question">Question:</label>
                <textarea class="form-control" id="question" name="question" rows="4" required></textarea>
            </div>
            
            <div class="form-group">
                <label for="tags">Tags (separate with commas):</label>
                <input type="text" class="form-control" id="tags" name="tags" placeholder="coding, java, MERN, development etc." required>
            </div>
            
            <button type="submit" class="btn btn-primary">Submit Question</button>
        </form>
    </div>
</body>

	</html>