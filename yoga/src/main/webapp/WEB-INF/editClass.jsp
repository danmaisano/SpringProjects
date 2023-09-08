<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Class</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Edit Class</h1>
    <form action="/editClass/${existingClass.id}" method="post">
        <input type="hidden" name="_method" value="PUT" />
    
        <div class="form-group mt-5">
            <label for="className">Class Name:</label>
            <input type="text" class="form-control" id="className" name="className" value="${existingClass.className}" placeholder="Enter class name" required>
        </div>
        
        <div class="form-group">
            <label for="dayOfWeek">Day of the Week:</label>
            <select class="form-control" id="dayOfWeek" name="dayOfWeek" required>
                <option value="" disabled ${existingClass.dayOfWeek == null ? 'selected' : ''}>Select a day</option>
                <c:forEach items="Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday" var="day">
                    <option value="${day}" ${day == existingClass.dayOfWeek ? 'selected' : ''}>${day}</option>
                </c:forEach>
            </select>
        </div>
        
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="number" class="form-control" id="price" name="price" value="${existingClass.price}" placeholder="Enter price" required>
        </div>
        
        <div class="form-group">
            <label for="time">Time:</label>
            <input type="time" class="form-control" id="time" name="time" value="${existingClass.time}" required>
    	</div>
        
        
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea class="form-control" id="description" name="description" rows="3" required>${existingClass.description}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
        <div class="btn-group mt-5" role="group" aria-label="Basic example">
        <a href="/dashboard">
            <button type="button" class="btn btn-warning">Cancel</button>
        </a>
        <form action="/deleteClass/${existingClass.id}" method="post" class="d-inline mx-5">
            <input type="hidden" name="_method" value="DELETE" />
            <button type="submit" class="btn btn-danger">Delete</button>
        </form>
    </div>
	</div>
</body>
</html>
