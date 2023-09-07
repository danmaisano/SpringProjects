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
    <title>Welcome</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
<h1 style="color:royalblue;">Dojo Overflow</h1>
<h3 style="color:rebeccapurple; "class="mb-5">Ask Questions, Get Answers</h3>
    <div class="row">
		<div class="col-md-6">
		    <h4>Register</h4>
		    <form:form action="/register" method="post" modelAttribute="newUser">
		        <div class="form-group">
		            <label for="name">Name</label>
		            <form:input type="text" path="name" class="form-control" id="name" placeholder="Enter Name"/>
		            <form:errors path="name" class="text-danger"/>
		        </div>
		        <div class="form-group">
		            <label for="email">Email address</label>
		            <form:input type="email" path="email" class="form-control" id="email" placeholder="Enter email"/>
		            <form:errors path="email" class="text-danger"/>
		        </div>
		        <div class="form-group">
		            <label for="password">Password</label>
		            <form:password path="password" class="form-control" id="password" placeholder="Password"/>
		            <form:errors path="password" class="text-danger"/>
		        </div>
		        <div class="form-group">
		            <label for="confirm">Confirm Password</label>
		            <form:password path="confirm" class="form-control" id="confirm" placeholder="Confirm Password"/>
		            <form:errors path="confirm" class="text-danger"/>
		            <c:if test="${not empty confirmError}">
        				<p class="text-danger">${confirmError}</p>
    				</c:if>
		        </div>
		        <button type="submit" class="btn btn-primary">Register</button>
		    </form:form>
		</div>

		<div class="col-md-6">
		    <h4>Login</h4>
		    <form:form action="/login" method="post" modelAttribute="newLogin">
		        <div class="form-group">
		            <label for="loginEmail">Email address</label>
		            <form:input type="email" path="loginEmail" class="form-control" id="loginEmail" placeholder="Enter email"/>
		            <form:errors path="loginEmail" class="text-danger"/>
		        </div>
		        <div class="form-group">
		            <label for="loginPassword">Password</label>
		            <form:password path="loginPassword" class="form-control" id="loginPassword" placeholder="Password"/>
		            <form:errors path="loginPassword" class="text-danger"/>
		        </div>
		        <button type="submit" class="btn btn-primary">Login</button>
		    </form:form>
		</div>
	</div>
</div>

<!-- Add Bootstrap 4 JS and its dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>