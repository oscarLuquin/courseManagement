package com.oscarMiniProject.web.model;

import java.sql.SQLException;
import java.util.List;

import com.oscarMiniProject.web.dao.TeacherDAO;

public class Teacher extends Person {
	
	  private String designation;

	  public String getDesignation() {
	    return designation;
	  }

	  public void setDesignation(String designation) {
	    this.designation = designation;
	  }
	  
	  public void addTeacher() throws SQLException {
		  
		  TeacherDAO.addTeacher(this);
	  }
	  
	  public List<Teacher> getTeachers() throws SQLException {
		  
		  return TeacherDAO.getTeachers();
	  }

}
