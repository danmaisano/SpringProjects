<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Class</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Create a Class</h1>

    <form action="/addClass" method="post">
        
        <div class="form-group mt-5">
		    <label for="className">Class Name:</label>
		    <input type="text" class="form-control" id="className" name="className" value="${newClass.className}" placeholder="Enter class name" required>
		</div>
		
		<div class="form-group">
		    <label for="dayOfWeek">Day of the Week:</label>
		    <select class="form-control" id="dayOfWeek" name="dayOfWeek" required>
		        <option value="" disabled ${newClass.dayOfWeek == null ? 'selected' : ''}>Select a day</option>
		        <c:forEach items="Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday" var="day">
		            <option value="${day}" ${day == newClass.dayOfWeek ? 'selected' : ''}>${day}</option>
		        </c:forEach>
		    </select>
		</div>
		
		<div class="form-group">
		    <label for="price">Price:</label>
		    <input type="number" class="form-control" id="price" name="price" value="${newClass.price}" placeholder="Enter price" required>
		</div>
		
		<div class="form-group">
		    <label for="time">Time:</label>
		    <input type="time" class="form-control" id="time" name="time" value="${newClass.time}" required>
		</div>
		
		<div class="form-group">
		    <label for="description">Description:</label>
		    <textarea class="form-control" id="description" name="description" rows="3" required>${newClass.description}</textarea>
		</div>
        
        <button type="submit" class="btn btn-primary">Submit</button>
        <a href="/dashboard" class="mb-5 h4"><button type="button" class="btn btn-warning">Cancel</button></a>
        
    </form>
</div>
</body>
</html>
