<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Film By ID</title>
</head>
<body>

<h1>Find film by ID</h1>

<form action="showFilm.do" method ="POST">
<input type="number" name="filmId"><br>
<button>Get Film by ID</button>
</form>


<c:choose>
<c:when test="${not empty film }">
	<h2> ${film.id }</h2>
	<h2> ${film.title }</h2>
	<h2> ${film.releaseYear}</h2>
	<h2> ${film.rating}</h2>
	<h2> ${film.description}</h2>
	<h2> ${film.actors } </h2>
	
	</c:when>
	<c:otherwise>
	<p> No Film found under that ID </p>
	</c:otherwise>
	</c:choose>
	
<form action = "deleteFilm.do" method = "POST" id="formDel">
<p>Do you want to delete this film?</p>
 <input type="hidden" name="filmId" value= "${film.id }" />
 <button type="submit">Delete Film</button><br>
</form>

<a href="updateFilmInfo.do">Update Film Info</a><br/>

</body>
</html>