package com.oscarMiniProject.web.dao;

import com.oscarMiniProject.web.model.Course;
import com.oscarMiniProject.web.model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
	
	public static Course getCourse(int cid) {
		
		Course c=new Course();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(DBmanager.database,DBmanager.user,DBmanager.password);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Course where id="+cid);
			if(rs.next()) {
				
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setCredits(rs.getInt("credits"));
			}
			
			if (rs != null) {
			    rs.close();}
		    if (st != null) {
			    st.close();
		    }
		    
		    con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		return c;	
	}
	
	public static void addCourse(Course c) throws SQLException {
		
		Connection con=null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection(DBmanager.database,DBmanager.user,DBmanager.password);//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management","root","unityps4");
			String sql="INSERT into course (name,credits,Teacher_id) "+ "VALUES (?,?,?)";
			ResultSet rs=null;
			PreparedStatement stmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			try {
				
				
				
				
				stmt.setString(1,c.getName());
				stmt.setInt(2,c.getCredits());
				if(c.getTeacher()!=null) {
					stmt.setInt(3, c.getTeacher().getId());
				}else {
					stmt.setNull(3, Types.NULL);
				}
				//stmt.setInt(3, c.getTeacher().getId());
				int affected=stmt.executeUpdate();
				if(affected==1) {
					
					rs=stmt.getGeneratedKeys();
					rs.next();
					int newKey=rs.getInt(1);
					c.setId(newKey);
				}else {
					
					System.out.println("could not add course and error ocurred");
					
				}
			}catch(Exception e1){
				System.out.println(e1);
			}finally {
				if(rs!=null) {
					rs.close();
					
				}
				if(stmt!=null) {
					stmt.close();
				}
				con.close();
			}
			
			
			
			
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}finally {
			con.close();
		}
	}

	public static List<Course> getCourses() throws SQLException{
		
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection(DBmanager.database,DBmanager.user,DBmanager.password);
		    
		    List<Course> courses=new ArrayList<Course>();
		    
		    Statement stmt = null;
		    ResultSet rs = null;
		    try {
		      stmt = con.createStatement();

		      //create SQL statement using left outer join
		      StringBuilder sb = new StringBuilder("select course.id as courseId, course.name as courseName,")
		        .append("course.credits as credits, Teacher.id as teacherId, Teacher.first_name as firstName, ")
		        .append("Teacher.last_name as lastName, Teacher.designation designation ")
		        .append("from Course left outer join Teacher on ")
		        .append("course.Teacher_id = Teacher.id ")
		        .append("order by course.name");

		  //execute the query
		      rs = stmt.executeQuery(sb.toString());

		  //iterate over result set and create Course objects
		  //add them to course list
		      while (rs.next()) {
		        Course course = new Course();
		        course.setId(rs.getInt("courseId"));
		        course.setName(rs.getString("courseName"));
		        course.setCredits(rs.getInt("credits"));
		        courses.add(course);

		        int teacherId = rs.getInt("teacherId");
		  //check whether teacher id was null in the table
		        if (rs.wasNull()) //no teacher set for this course.
		          continue;
		        Teacher teacher = new Teacher();
		        teacher.setId(teacherId);
		        teacher.setFirstName(rs.getString("firstName"));
		        teacher.setLastName(rs.getString("lastName"));
		        teacher.setDesignation(rs.getString("designation"));
		        course.setTeacher(teacher);
		      }

		      return courses;
		    }
		  finally {
		    try {if (rs != null) rs.close();} catch (SQLException e) {}
		    try {if (stmt != null) stmt.close();} catch (SQLException e) {}
		    try {con.close();} catch (SQLException e) {}
		    }
			
		}catch(Exception e) {
			
			System.out.println(e);
			
			return null;
			
		}
		finally {
			con.close();
		}
		
	}
	
	public static void updateCourse(Course c) throws SQLException {
		
		Connection con=null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection(DBmanager.database,DBmanager.user,DBmanager.password);
			String sql="update course set name=? , credits=? , Teacher_id=? where id=?";
			ResultSet rs=null;
			PreparedStatement stmt=con.prepareStatement(sql);
			try {
				
				
				
				
				stmt.setString(1,c.getName());
				stmt.setInt(2,c.getCredits());
				stmt.setInt(3,c.getTeacher().getId());
				stmt.setInt(4, c.getId());
				
				int affected=stmt.executeUpdate();
				if(affected==1) {
					
					
				}else {
					
					System.out.println("could not add course and error ocurred");
					
				}
			}catch(Exception e1){
				System.out.println(e1);
			}finally {
				if(rs!=null) {
					rs.close();
					
				}
				if(stmt!=null) {
					stmt.close();
				}
				con.close();
			}
			
			
			
			
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}finally {
			con.close();
		}
		
	}
	
	public static void deleteCourse(Course c) throws SQLException {
		
		Connection con=null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(DBmanager.database,DBmanager.user,DBmanager.password);
			String sql="delete from course where id=?";
			ResultSet rs=null;
			PreparedStatement stmt=con.prepareStatement(sql);
			try {
				
				stmt.setInt(1,c.getId());
				
				int affected=stmt.executeUpdate();
				if(affected==1) {
					
					
				}else {
					
					System.out.println("could not delete the course and error ocurred");
					
				}
			}catch(Exception e1){
				System.out.println(e1);
			}finally {
				if(rs!=null) {
					rs.close();
					
				}
				if(stmt!=null) {
					stmt.close();
				}
				con.close();
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}finally {
			con.close();
		}
	}
}
