<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${yogaClass.className}</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">

        <div class="d-flex justify-content-between align-items-center">
            <h1 class="font-italic">${yogaClass.className}</h1>
            <!-- New button -->
            <a href="/dashboard" class="btn btn-secondary">Back to Dashboard</a>
        </div>

		<p style="font-size: 1.4em;">Day: ${yogaClass.dayOfWeek}</p>
		<p style="font-size: 1.4em;">Cost: <fmt:formatNumber type="currency" value="${yogaClass.price}" /></p>
		<p style="font-size: 1.4em;">
			Time:
			<c:choose>
		        <c:when test="${fn:split(yogaClass.time, ':')[0] >= 12}">
		            <c:set var="hour" value="${fn:split(yogaClass.time, ':')[0] - 12}" />
		            <c:choose>
		                <c:when test="${hour == 0}">
		                    <c:set var="hour" value="12" />
		                </c:when>
		            </c:choose>
		            <c:set var="hour" value="${hour}" />
		            <c:out value="${Integer.valueOf(hour)}:${fn:split(yogaClass.time, ':')[1]} pm" />
		        </c:when>
		        <c:otherwise>
		            <c:set var="hour" value="${fn:split(yogaClass.time, ':')[0]}" />
		            <c:choose>
		                <c:when test="${hour == 0}">
		                    <c:set var="hour" value="12" />
		                </c:when>
		            </c:choose>
		            <c:set var="hour" value="${hour}" />
		            <c:out value="${Integer.valueOf(hour)}:${fn:split(yogaClass.time, ':')[1]} am" />
		        </c:otherwise>
		    </c:choose>
	    </p>


        <p class="font-italic">${yogaClass.description}</p>

        <hr />

        <h4 class="font-italic">Students</h4>

        <ul>
            <c:forEach var="student" items="${yogaClass.students}">
                <li>${student.studentName} - ${student.studentEmail}</li>
            </c:forEach>
        </ul>
        <br>

		<h4 class="font-italic">Add students to this class</h4>
		<br>
		
		<div class="row">
		
		    <div class="col-md-6">
		        <form action="/addNewStudent" method="post">
		            <input type="hidden" name="classId" value="${yogaClass.id}" />
		            <h5>New Student</h5>
		            <input type="text" class="form-control" placeholder="Student Name" name="studentName">
		            <input type="email" class="form-control mt-2" placeholder="Student Email" name="studentEmail">
		            <button type="submit" class="btn btn-primary mt-2">Add New Student</button>
		        </form>
		    </div>
		
		    <div class="col-md-6">
		        <form action="/addExistingStudent" method="post">
		            <input type="hidden" name="classId" value="${yogaClass.id}" />
		            <h5>Existing Student</h5>
		            <select class="form-control" name="existingStudent">
		                <c:forEach var="student" items="${allStudents}">
		                    <option value="${student.studentName}">${student.studentName}</option>
		                </c:forEach>
		            </select>
		            <button type="submit" class="btn btn-primary mt-2">Add Existing Student</button>
		            <c:if test="${not empty errorMessage}">
		                <div class="text-danger mt-2">
		                    ${errorMessage}
		                </div>
		            </c:if>
		        </form>
		    </div>
		
		</div>
	</div>


</body>
</html>
