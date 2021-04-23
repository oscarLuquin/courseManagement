<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.oscarMiniProject.web.model.Teacher" %>
<%@ page import="com.oscarMiniProject.web.model.Course" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
	*{
 	padding : 0;
 	margin : 0;
 	}
	body{
		background-color: #457b9d;
		
		
	}
	#header{
		text-align: left;
		background-color: #023047;
		color: #fff1e6;
		padding: 15px;
		margin:0px;
		
	}

	input{
	
		margin:5px;
		
	}
	form{
		padding: 50px 10px;
		margin: 0px;
		
	}
	

	#addcourse{
		background-color: #2a9d8f;
		width: 70%;
		height: 20%;
		
	}

	#modifycourse{
		background-color: #e5e5e5;
		height: 20%;
		width: 70%;
	}
	
	#deletecourse{
		width: 70%;
		background-color: #354f52;
		height: 20%;
	}
	
	

	
</style>
</head>
<body >


	<header id="header">

		<h1>welcome to course manager</h1>
	</header>
	
	

	<%
	
		String message=(String) request.getAttribute("message");
		if(message!=null){%>
			
			<h2><%=message %></h2>
		<% }
	%>
	<form action="addCourse" method="post" id="addcourse">
		
		<h3>add a course</h3>
		<label for="courseName">course name:</label>
		<input type="text" name="courseName">
		<label for="credits" >credits: </label>
		<input type="text" name="credits">
		<!--<label for="teacher">Teacher id</label>
		  <input type="text" name="teacher">
		<input type="submit" name="addcourse">-->
		
		<label for="teacher">select a teacher: </label>
	<%!Teacher t=new Teacher();  %>
	<select name="teacher">
	<%
		List<Teacher> teachers=t.getTeachers();
		for(Teacher t1: teachers ){%>
			
		<option value=<%=t1.getId() %>><%=t1.getFirstName() %></option>	
		<% }
	%>
	
	</select>
		<input type="submit" value="add course">
	</form>
	
	<form action="modCourse" method="post" id="modifycourse">
	<h2>modify a course</h2>
	
		<%!Course c=new Course();  %>
	<select name="courseId">
	<%
		List<Course> courses=c.getCourses();
		for(Course c1: courses ){%>
			
		<option value=<%=c1.getId() %>><%=c1.getName() %></option>	
		<% }
	%></select>
	<label for="courseName">course name </label>
	<input type="text" name="courseName">
	<label for="credits">credits</label>
	<input type="text" name="credits">
	<label for="teacher">teacher</label>
	<select name="teacher">
	<%
		
		for(Teacher t1: teachers ){%>
			
		<option value=<%=t1.getId() %>><%=t1.getFirstName() %></option>	
		<% }
	%>
	
	</select>
	<input type="submit" value="modify course">
	
	</form>
	
	<form action="deleteCourse" method="post" id="deletecourse">
	
		<h2>delete course</h2>
		<select name="courseId">
	<%
		
		for(Course c1: courses ){%>
			
		<option value=<%=c1.getId() %>><%=c1.getName() %></option>	
		<% }
	%></select>
	
	<input type="submit" value="delete course">
		
	</form>

	

</body>
</html>