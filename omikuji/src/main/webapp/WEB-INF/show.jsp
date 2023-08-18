<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
    .blue-box {
        background-color: #007bff; 
        color: black;
        padding: 15px; 
        width: 15vw;
        box-shadow: 5px 5px black; 
        margin: 0 auto; 
    }
</style>
</head>
<body>
    <div class="container mt-5 text-center">
        <h1>Here's Your Omikuji!</h1>
        <div class="blue-box mt-5 mb-5">
            <h4>In <c:out value="${pickNumber}"/> years you will live in <c:out value="${pickCity}"/> with <c:out value="${pickPerson}"/> as your room mate, <c:out value="${pickHobby}"/> for a living. The next time you see a <c:out value="${pickAnimal}"/> you will have good luck.  Also, <c:out value="${pickSaying}"/></h4>
        </div>
        <a class="mt-5" href="/omikuji">Go Back</a>
    </div>

    <!-- Bootstrap JS (Optional) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
