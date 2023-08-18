<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<div class="col-md-6 text-center mt-5">
				<h3>Current Count: <c:out value="${count}"/></h3>
				<a href="/reset"><button>Reset Counter</button></a>
				<a href="/">Go Home</a>
			</div>
		</div>
	</div>
</body>
</html>