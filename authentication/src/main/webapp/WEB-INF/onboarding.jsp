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
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Tell Us About You!</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container mt-5">
    <h1>Enter Your Favorites</h1>
    <form action="/submitFavs" method="post">
      <div class="mb-3">
        <label for="favBook" class="form-label">Favorite Book</label>
        <input type="text" class="form-control" id="favBook" name="favBook">
      </div>
      <div class="mb-3">
        <label for="favFood" class="form-label">Favorite Food</label>
        <input type="text" class="form-control" id="favFood" name="favFood">
      </div>
      <div class="mb-3">
        <label class="form-label">Favorite Coding Languages</label>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="Java" id="javaCheck" name="favCodingLanguage[]">
          <label class="form-check-label" for="javaCheck">Java</label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="Javascript" id="jsCheck" name="favCodingLanguage[]">
          <label class="form-check-label" for="jsCheck">Javascript</label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="Python" id="pythonCheck" name="favCodingLanguage[]">
          <label class="form-check-label" for="pythonCheck">Python</label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="React" id="reactCheck" name="favCodingLanguage[]">
          <label class="form-check-label" for="reactCheck">React</label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="checkbox" value="SQL" id="sqlCheck" name="favCodingLanguage[]">
          <label class="form-check-label" for="sqlCheck">SQL</label>
        </div>
      </div>
      <div class="mb-3">
        <label for="favPet" class="form-label">Favorite Pet</label>
        <select class="form-select" id="favPet" name="favPet">
          <option value="Lana">Lana</option>
          <option value="Lana">Lana</option>
          <option value="Lana">Lana</option>
          <option value="Lana">Lana</option>
          <option value="Lana">Lana</option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</body>
</html>