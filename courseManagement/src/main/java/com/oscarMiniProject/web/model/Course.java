package com.oscarMiniProject.web.model;

import java.sql.SQLException;
import java.util.List;

import com.oscarMiniProject.web.dao.CourseDAO;



public class Course {
	  private int id;
	  private String name;
	  private int credits;
	  private Teacher teacher=new Teacher();
	  
	  
	  public int getId() {
	    return id;
	  }
	  public void setId(int id) {
	    this.id = id;
	  }
	  public String getName() {
	    return name;
	  }
	  public void setName(String name) {
	    this.name = name;
	  }
	  public int getCredits() {
	    return credits;
	  }
	  public void setCredits(int credits) {
	    this.credits = credits;
	  }
	  
	  
	  public boolean isValidCourse() {
		    return name != null && credits != 0;
	  }
	  
	  public void addCourse() throws SQLException {
		  CourseDAO.addCourse(this);
		  
	  }
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", credits=" + credits + "]";
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public List<Course> getCourses() throws SQLException {
		  return CourseDAO.getCourses();
	}
	
	public void updateCourse() throws SQLException{
		CourseDAO.updateCourse(this);
	}
	  
	public void deleteCourse() throws SQLException{
		CourseDAO.deleteCourse(this);
	}  

}
