package com.oscarMiniProject.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oscarMiniProject.web.model.Course;


/**
 * Servlet implementation class DeleteCourseServlet
 */
public class DeleteCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		     
		     Integer courseId=Integer.parseInt(request.getParameter("courseId"));
		     
		     if(courseId!=null) {
					
		    	 	
					Course c=new Course();
					c.setId(courseId);
					
					
					
					try {
						c.deleteCourse();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						request.setAttribute("message", "could not delete the course");
					}
					
					request.setAttribute("message","course deleted");
				}else {
					
					request.setAttribute("message","enter valid values");
				}
		     
			
			}catch(Exception e) {
				request.setAttribute("message","enter valid values");
			}
			
			
			
			
			RequestDispatcher rd=request.getRequestDispatcher("addCourse.jsp");
			rd.forward(request,response);
	}

}
