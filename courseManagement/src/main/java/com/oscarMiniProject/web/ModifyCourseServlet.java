package com.oscarMiniProject.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oscarMiniProject.web.dao.TeacherDAO;
import com.oscarMiniProject.web.model.Course;
import com.oscarMiniProject.web.model.Teacher;

/**
 * Servlet implementation class ModifyCourseServlet
 */

@WebServlet("/modCourse")
public class ModifyCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		     String courseName=(String) request.getParameter("courseName");
		     Integer courseId=Integer.parseInt(request.getParameter("courseId"));
		     Integer credits=Integer.parseInt(request.getParameter("credits"));
		     Integer teacher=Integer.parseInt(request.getParameter("teacher"));
		     Teacher t=TeacherDAO.getTeacher(teacher);
		     if(courseId!=null && courseName!=null && credits!=null && t!=null) {
					
		    	 	
					Course c=new Course();
					c.setId(courseId);
					c.setName(courseName);
					c.setCredits(credits);
					c.setTeacher(t);
					
					
					try {
						c.updateCourse();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						request.setAttribute("message", "could not update the course");
					}
					
					request.setAttribute("message","course updated");
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
