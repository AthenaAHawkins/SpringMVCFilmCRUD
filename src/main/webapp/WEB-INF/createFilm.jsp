<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create Film</title>
</head>
<body>

<h1>Create Film</h1>

<form action="createFilm.do" method ="POST">


Title: <input type="text" name="title" value ="${film.title }">
Description: <input type="text" name="description" value="${film.description }">
Release Year: <input type="number" name="releaseYear" value="${film.releaseYear }">



 <button type="submit">Submit Film</button><br>

</form>





</body>
</html>