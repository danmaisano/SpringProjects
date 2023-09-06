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
    <title>Book Details</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">

        <div class="d-flex justify-content-between align-items-center">
            <h1><i>${book.title}</i></h1>
            <a href="/dashboard"><button class="btn btn-info">Back to the Shelves</button></a>
        </div>

        <h2 class="mt-5">
            <span class="text-danger"><c:out value="${book.postedBy.name}"/></span> read 
            <span style="color: MediumOrchid;"><c:out value="${book.title}"/></span> by 
            <span class="text-success"><c:out value="${book.author}"/></span>
        </h2>

        <h4 class="mt-4"><c:out value="Here are ${book.postedBy.name}'s thoughts:"/></h4>
        <hr class="my-4"/>
        <p>${book.thoughts}</p>
        <hr class="my-4"/>

        <c:if test="${user.id == book.postedBy.id}">
            <div class="d-flex justify-content-center">
                <a href="/edit/${book.id}"><button class="btn btn-warning mx-3">Edit Book</button></a>
                <form action="/delete/${book.id}" method="post">
                    <input type="hidden" name="_method" value="DELETE" />
				    <button type="submit" class="btn btn-danger mx-3">Delete Book</button>
				</form>
            </div>
        </c:if>
    </div>
</body>
</html>
