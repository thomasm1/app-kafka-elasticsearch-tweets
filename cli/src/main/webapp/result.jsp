<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Result</title>
</head>
<body>
<% 
int result = (Integer) request.getAttribute("result");
out.println("Average of 2: "+ result);
%>
<div>
MVC: ${msg}</div>
</body>
</html>