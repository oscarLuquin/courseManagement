package com.oscarMiniProject.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oscarMiniProject.web.dao.CourseDAO;
import com.oscarMiniProject.web.model.Course;

/**
 * Servlet implementation class GetCourseController
 */
@WebServlet("/getCourse")
public class GetCourseController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cid=Integer.parseInt(request.getParameter("id"));
		
		CourseDAO dao=new CourseDAO();
		Course c=dao.getCourse(cid);
		
		request.setAttribute("course", c);
		
		RequestDispatcher rd=request.getRequestDispatcher("showCourse.jsp");
		rd.forward(request,response);
		
		
		
	}

	

}
