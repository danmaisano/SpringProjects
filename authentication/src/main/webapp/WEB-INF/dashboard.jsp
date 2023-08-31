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
    <title>Success!</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">You're logged in ${user.name}</h1>
        
        <div class="card mt-5">
            <div class="card-header">
                Your Favorites
            </div>
            <div class="card-body">
                <h5 class="card-title">Favorite Book:</h5>
                <p class="card-text"><c:out value="${user.favBook}"/></p>
                
                <h5 class="card-title">Favorite Food:</h5>
                <p class="card-text"><c:out value="${user.favFood}"/></p>
                
                <h5 class="card-title">Favorite Pet:</h5>
                <p class="card-text"><c:out value="${user.favPet}"/></p>
				<img src="https://drive.google.com/uc?export=view&id=1vzOpMoz0q6_h28upvfTYGlPeK7yMnj5U" class="img-fluid" style="max-width: 25%;">
				<h4>Isn't she awesome!?</h4>
                
                <h5 class="card-title mt-5">Favorite Coding Languages:</h5>
                <ul>
                    <c:forEach items="${user.favCodingLanguage}" var="language">
                        <li><c:out value="${language}"/></li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="mt-3">
            <a href="/logout" class="btn btn-danger">Logout</a>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
