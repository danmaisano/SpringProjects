<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${question.question}</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">${question.question}</h1>
        <a href="/dashboard" class="btn btn-link mb-5 h4">Return to Dashboard</a>
        
        <h3 class="mt-3">Tags:</h3>
        <div>
            <c:forEach var="tag" items="${tags}">
				<span class="badge badge-secondary" style="font-size: 16px;">${tag.subject}</span>
            </c:forEach>
        </div>

        <h3 class="mt-4">Answers:</h3>
        <ul>
            <c:forEach var="answer" items="${answers}">
                <li>${answer.text}</li>
            </c:forEach>
        </ul>

		<h2 class="mt-4">Add your answer:</h2>
		<form:form action="/addAnswer" method="post" modelAttribute="newAnswer">
		    <input type="hidden" name="question_id" value="${question.id}"/>
		    <div class="form-group">
		        <label for="answer">Your Answer:</label>
		        <textarea class="form-control" id="answer" name="text" rows="3"></textarea>
		    </div>
		    <button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
    </div>
</body>
</html>
