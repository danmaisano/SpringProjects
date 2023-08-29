<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${dorm.name}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body class="container mt-5">
    <a href="<%= request.getContextPath() %>/" class="btn btn-primary mb-4">Home</a>

    <h1 class="mb-4">${dorm.name}</h1>
    <h3 class="mb-3">Reassign Student</h3>
    <form action="/assignStudentToDorm" method="post">
    <input type="hidden" name="dormId" value="${dorm.id}">
    <select id="studentSelect" name="studentId" class="form-select mb-3">
        <option selected>Select Student</option>
        <c:forEach var="student" items="${allStudents}">
		    <option value="${student.id}" data-current-dorm="${student.dorm.id}">
		        ${student.name} (Current: ${student.dorm.name})
		    </option>
		</c:forEach>

    </select>
	<select id="dormSelect" name="newDormId" class="form-select mb-3">
	    <option selected>Select New Dorm</option>
	    <c:forEach var="dorm" items="${allDorms}">
	        <c:if test="${dorm.id != student.dorm.id}">
	            <option value="${dorm.id}">${dorm.name}</option>
	        </c:if>
	    </c:forEach>
	</select>
    <input type="submit" class="btn btn-success" value="Reassign">
</form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th class="text-center">Name</th>
                <th class="text-center">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${allStudents}">
                <tr>
                    <td class="text-center">${student.name}</td>
                    <td>
                       <form action="/student/delete/${student.id}" method="post" class="text-center">
						    <input type="hidden" name="studentId" value="${student.id}">
						    <input type="hidden" name="dormId" value="${dorm.id}">
						    <input type="submit" class="btn btn-danger" value="Remove">
						</form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<script>
document.addEventListener("DOMContentLoaded", function() {
    const studentSelect = document.getElementById("studentSelect");
    const dormSelect = document.getElementById("dormSelect");

    studentSelect.addEventListener("change", function() {
        const selectedStudentOption = studentSelect.options[studentSelect.selectedIndex];
        const currentDormId = selectedStudentOption.getAttribute("data-current-dorm");

        for (let i = 0; i < dormSelect.options.length; i++) {
            const dormOption = dormSelect.options[i];
            if (dormOption.value === currentDormId) {
                dormOption.style.display = "none"; 
            } else {
                dormOption.style.display = "block";
            }
        }
    });
});
</script>
</body>
</html>
