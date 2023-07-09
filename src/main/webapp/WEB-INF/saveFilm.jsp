<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Film</title>
</head>
<body>
<form action="saveFilm.do" method="POST" id="formSave">
Title: <input type = "text" name="filmInfo" value= "${film.title }"><br>
Description: <input type="text" name="filmInfo" value= "${film.description }" /><br>
Release Year: <input type="text" name="filmInfo" value= "${film.releaseYear }" /><br>
<button type="submit">Submit Changes</button>
</form>


</body>
</html>