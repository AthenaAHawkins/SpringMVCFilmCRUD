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
Title: <input type="text" name="Title">
Description: <input type="text" name="Description">
Language ID: <input type="text" name="languageID">

</form>



</body>
</html>