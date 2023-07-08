<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Film Site</title>
</head>
<body>

<h1>Film Query full-stack</h1>

<form action="showFilm.do" method ="POST">
<input type="number" name="filmId"><br>
<button>Get Film by ID</button>
</form>

<form action="createFilm.do" method ="POST">
<input type="text" name="createFilm">
<br>
<button>Create a new Film</button>
</form>

<c:choose>
<c:when test="${not empty film }">
	<h2> ${film.title }</h2>
	<h2> ${film.releaseYear}</h2>
	<h2> ${film.rating}</h2>
	<h2> ${film.description}</h2>
	
	</c:when>
	<c:otherwise>
	</c:otherwise>
	</c:choose>


</body>
</html>