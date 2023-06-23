<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Result</title>
</head>
<body>

<jsp:useBean id="userDetails" type="app.mapl.models.User" scope="request"/>
Id: <jsp:getProperty property="userId" name="userDetails"/>
Name: <jsp:getProperty property="userName" name="userDetails"/>
</body>
</html>