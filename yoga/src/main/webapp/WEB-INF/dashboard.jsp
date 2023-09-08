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
    <title>Yoga Class Dashboard</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body>
    
    <div class="container">
    	<div class="d-flex justify-content-between align-items-center">
        	<h1 class="mt-5">Namaste, ${user.name}</h1>
        	 <a href="/logout" class="btn btn-secondary">Logout</a>
        </div>
        <h4>Course Schedule</h4>
        <table class="table table-striped mt-5">
            <thead>
                <tr>
                    <th>Class Name</th>
                    <th>Instructor</th>
                    <th>Day of the Week</th>
                    <th>Price</th>
                    <th>Time</th>
                </tr>
            </thead>
            <c:forEach var="yogaClass" items="${classes}">
		        <tr>
		            <td>
		                <a href="/classes/${yogaClass.id}">${yogaClass.className}</a>
		                <c:if test="${yogaClass.instructor.id == user.id}">
		                    <a href="/editClass/${yogaClass.id}" class="btn btn-sm btn-secondary ml-2">Edit</a>
		                </c:if>
		            </td>
		            <td>${yogaClass.instructor.name}</td>
		            <td>${yogaClass.dayOfWeek}</td>
		            <td><fmt:formatNumber type="currency" value="${yogaClass.price}" /></td>
					<td>
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
					</td>
                   </tr>
               </c:forEach>
            </tbody>
        </table>
    </div>
    
    <div class="container mt-3">
        <a href="/addClass" class="btn btn-primary mt-5">New Class</a>
    </div>
</body>
</html>
