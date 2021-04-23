<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="com.oscarMiniProject.web.model.Course" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Course c=new Course();
		List<Course> courses=c.getCourses();
		
		if(courses!=null){%>
	<table>
	  <tr>
	  <th>Id</th>
      <th>Name</th>
      <th>Credits</th>
      <th>Teacher</th>
     
      </tr>
      <%for(int i=0;i<courses.size();i++){ %>
      <tr>
      
      	<td><%=courses.get(i).getId() %></td>
      	<td><%=courses.get(i).getName() %></td>
      	<td><%=courses.get(i).getCredits() %></td>
      	<td><%if(courses.get(i).getTeacher()!=null) {%>
      	
      		<%=courses.get(i).getTeacher().getFirstName() %>
      		
      	<%} %>
      	</td>
      </tr>
     <%} %>
	</table>
	<%} %>
	
</body>
</html>