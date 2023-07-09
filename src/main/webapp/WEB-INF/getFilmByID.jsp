


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Info</title>
</head>
<body>

<h3>Find film by ID</h3>

<form action="showFilm.do" method="POST">
    <input type="number" name="filmId"><br>
    <button>Get Film by ID</button>
</form>

<h3>Find Film by Keyword</h3>

<form action="searchFilms.do" method="POST">
    <input type="text" name="keyword"><br>
    <button>Get Film by Keyword</button>
</form>

<c:choose>
    <c:when test="${not empty film}">
        <p>Film ID: ${film.id}</p>
        <p>Film Title: ${film.title}</p>
        <p>Film Release Year: ${film.releaseYear}</p>
        <p>Film Rating: ${film.rating}</p>
        <p>Film Description: ${film.description}</p>
        <p>Actors involved:</p>
        <ul>
            <c:forEach items="${film.actors}" var="actor">
                <li>${actor.firstName} ${actor.lastName}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:when test="${not empty films}">
        <h4>Search Results:</h4>
        <c:forEach items="${films}" var="film">
            <p>Film ID: ${film.id}</p>
            <p>Film Title: ${film.title}</p>
            <p>Film Release Year: ${film.releaseYear}</p>
            <p>Film Rating: ${film.rating}</p>
            <p>Film Description: ${film.description}</p>
            <p>Actors involved:</p>
            <ul>
                <c:forEach items="${film.actors}" var="actor">
                    <li>${actor.firstName} ${actor.lastName}</li>
                </c:forEach>
            </ul>
            <hr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>No Film found under that ID or keyword</p>
    </c:otherwise>
</c:choose>

<form action="deleteFilm.do" method="POST" id="formDel">
    <p>Do you want to delete this film?</p>
    <input type="hidden" name="filmId" value="${film.id}" />
    <button type="submit">Delete Film</button><br>
</form>

<form action="saveFilm.do" method ="POST">
 <input type="hidden" name="ID" value="${film.id}" />
Title:<input type = "text" name="mvTitle" value = "${film.title }"><br>
Description:<input type = "text" name="mvDesc" value = "${film.description }"><br>
LanguageId:<input type = "text" name="langID" value = "${film.languageId }"><br>
<button type="submit">Submit Changes</button><br>
</form>

</body>
</html>




