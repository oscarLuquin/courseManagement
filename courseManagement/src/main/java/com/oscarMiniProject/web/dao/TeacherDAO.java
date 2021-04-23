package com.oscarMiniProject.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.oscarMiniProject.web.model.Teacher;

public class TeacherDAO {

	
public static Teacher getTeacher(int tid) {
		
		Teacher t=new Teacher();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(DBmanager.database,DBmanager.user,DBmanager.password);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Teacher where id="+tid);
			if(rs.next()) {
				
				t.setId(rs.getInt("id"));
				t.setFirstName(rs.getString("first_name"));
				t.setLastName(rs.getString("last_name"));
				t.setDesignation(rs.getString("designation"));
			}else {
				if (rs != null) {
				    rs.close();}
			    if (st != null) {
				    st.close();
			    }
			    con.close();
			    return null;
				
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
		
		
		return t;	
	}

 public static void addTeacher(Teacher t) throws SQLException {
	
	Connection con=null;
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
	    con=DriverManager.getConnection(DBmanager.database,DBmanager.user,DBmanager.password);
		String sql="INSERT into teacher (first_name,last_name,designation) "+ "VALUES (?,?,?)";
		ResultSet rs=null;
		PreparedStatement stmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		try {
			
			
			
			
			stmt.setString(1,t.getFirstName());
			stmt.setString(2,t.getLastName());
			stmt.setString(3,t.getDesignation());
			
			int affected=stmt.executeUpdate();
			if(affected==1) {
				
				rs=stmt.getGeneratedKeys();
				rs.next();
				int newKey=rs.getInt(1);
				t.setId(newKey);
			}else {
				
				System.out.println("could not add teacher and error ocurred");
				
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
	public static List<Teacher> getTeachers() throws SQLException{
	
		List<Teacher> teachers=new ArrayList<>();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(DBmanager.database,DBmanager.user,DBmanager.password);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Teacher");
			while(rs.next()) {
				
				Teacher t=new Teacher();
				t.setId(rs.getInt("id"));
				t.setFirstName(rs.getString("first_name"));
				t.setLastName(rs.getString("last_name"));
				t.setDesignation(rs.getString("designation"));
				
				teachers.add(t);
				
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
		
		
		return teachers;
	
  }
}
