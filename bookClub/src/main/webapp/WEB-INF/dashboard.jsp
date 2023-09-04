<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Books</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-8 mt-5">
                <h1>Welcome, <c:out value="${user.name}" /></h1>
                <h2 class="mt-5">Books from everyone's shelves</h2>
            </div>
            <div class="col-md-4 text-end mt-5">
                <a href="/addBook" class="btn btn-primary ml-5">Add a book</a>
                <a href="/logout" class="btn btn-danger mx-5">Logout</a>
            </div>
        </div>
        <div class="row">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author Name</th>
                        <th>Posted By</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Loop through the list of books -->
                    <c:forEach items="${books}" var="book">
                        <tr>
                            <td><c:out value="${book.id}" /></td>
                            <td><a href="/book/${book.id}"><c:out value="${book.title}" /></a></td>
                            <td><c:out value="${book.author}" /></td>
                            <td><c:out value="${book.postedBy.name}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
