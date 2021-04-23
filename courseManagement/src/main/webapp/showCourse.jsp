<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.oscarMiniProject.web.model.Course" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>show courses page</h2>
	
	<%
	
		Course course=(Course) request.getAttribute("course");
		out.println(course);
	%>

</body>
</html>