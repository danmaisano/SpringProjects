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
    <title>Questions Dashboard</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    
    <div class="container">
    <h1 class="mt-5">Questions Dashboard</h1>
    <h4>Welcome ${user.name}</h4>
        <table class="table table-striped mt-5">
            <thead>
                <tr>
                    <th>Questions</th>
                    <th>Tags</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach var="question" items="${questions}">
                    <tr>
                        <td><a href="/question/${question.id}">${question.question}</a></td>
                        <td>
						  <c:forEach var="tag" items="${question.tags}">
						    ${tag.subject} 
						  </c:forEach>
						</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    <div class="container mt-3">
        <a href="/addQuestion" class="btn btn-primary mt-5">Post a new question</a>
    </div>
</body>
</html>
