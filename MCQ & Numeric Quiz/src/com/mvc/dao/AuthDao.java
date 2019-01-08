package com.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class AuthDao {
	public static UserBean getUserById (int userId){
		UserBean user = new UserBean();
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from userprofile where userid=?");   
		ps.setInt(1,userId);  
		ResultSet rs = ps.executeQuery();
		      
		if(rs.next()){
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            return user;
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return null;
	}
	
	public static boolean checkUserPass(String username,String password,String role){
		boolean status=false; 
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from user where username=? and password=? and role=?");   
		ps.setString(1,username);
		ps.setString(2,password);
		ps.setString(3,role);
		ResultSet rs = ps.executeQuery();
		status=rs.next();
		}
		catch(Exception e)
		{System.out.println(e);}  
		return status;
	}
	
	public static boolean checkUserName(String username){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from user where username=?");   
		ps.setString(1,username);  
		ResultSet rs = ps.executeQuery();
		      
		if(rs.next()){
			if(username.equals(rs.getString("username"))) return false;            
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return true;
	}
	
	public static boolean checkMCQLast(int mcqid){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select MAX(mcqid) from mcqquestion");   

		ResultSet rs = ps.executeQuery();     
		if(rs.next()){
			if(rs.getInt(1) == mcqid) return true;            
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return false;
	}
	
	public static boolean checkNumLast(int numid){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select MAX(numid) from numquestion");   

		ResultSet rs = ps.executeQuery();     
		if(rs.next()){
			if(rs.getInt(1) == numid) return true;            
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return false;
	}
	
	public static boolean checkMCQAnswer(int mcqid, String answer){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from mcqquestion where mcqid=?");   
		ps.setInt(1,mcqid);  
		ResultSet rs = ps.executeQuery();
		      
		if(rs.next()){
			if(answer.equals(rs.getString("answer"))) return true;            
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return false;
	}
	
	public static boolean checkNumAnswer(int numid, String answer){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from numquestion where numid=?");   
		ps.setInt(1,numid);  
		ResultSet rs = ps.executeQuery();
		      
		if(rs.next()){
			if(answer.equalsIgnoreCase(rs.getString("answer"))) return true;            
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return false;
	}
	
	public static boolean checkMCQQuestion(String question){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from mcqquestion where question=?");   
		ps.setString(1,question);  
		ResultSet rs = ps.executeQuery();
		      
		if(rs.next()){
			if(question.equalsIgnoreCase(rs.getString("question"))) return false;            
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return true;
	}
	
	public static boolean checkNumQuestion(String question){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from numquestion where question=?");   
		ps.setString(1,question);  
		ResultSet rs = ps.executeQuery();
		      
		if(rs.next()){
			if(question.equalsIgnoreCase(rs.getString("question"))) return false;            
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return true;
	}
	
	public static boolean enterNewUser(String username,String password,String role,String firstname,String lastname){  
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"insert into user(username,password,role) values (?,?,?)");   
		ps.setString(1,username);  
		ps.setString(2,password);
		ps.setString(3,role);
		int i = ps.executeUpdate();
		if(i>0){
			ps=con.prepareStatement(  
					"select userid from user where username=?");   
					ps.setString(1,username);  
					ResultSet rs = ps.executeQuery();
					      
					if(rs.next()){
						ps=con.prepareStatement("insert into userprofile(userid,firstname,lastname) values (?,?,?)");   
						ps.setInt(1,rs.getInt("userid"));  
						ps.setString(2,firstname);
						ps.setString(3,lastname);
						int j = ps.executeUpdate();
						if(j>0) return true;
					}
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return false;
	}
	
	public static boolean enterNewMCQQuestion(String question,String choicea,String choiceb,String choicec,String choiced,String mcqanswer,
			String mcqhint1,String mcqhint2,String mcqhint3,String mcqfeedback){  
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"insert into mcqquestion(question,choicea,choiceb,choicec,choiced,answer,hint1,hint2,hint3,feedback) values (?,?,?,?,?,?,?,?,?,?)");   
		ps.setString(1,question);  
		ps.setString(2,choicea);
		ps.setString(3,choiceb);
		ps.setString(4,choicec);
		ps.setString(5,choiced);
		ps.setString(6,mcqanswer);
		ps.setString(7,mcqhint1);
		ps.setString(8,mcqhint2);
		ps.setString(9,mcqhint3);
		ps.setString(10,mcqfeedback);
		int i = ps.executeUpdate();
		if(i>0) return true;
		}
		catch(Exception e)
		{System.out.println(e);}  
		return false;
	}
	
	public static boolean enterNewNumQuestion(String question,String answer,String hint1,String hint2,String hint3,String feedback){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"insert into numquestion(question,answer,hint1,hint2,hint3,feedback) values (?,?,?,?,?,?)");   
		ps.setString(1,question);  
		ps.setString(2,answer);
		ps.setString(3,hint1);
		ps.setString(4,hint2);
		ps.setString(5,hint3);
		ps.setString(6,feedback);
		int i = ps.executeUpdate();
		if(i>0) return true;
		}
		catch(Exception e)
		{System.out.println(e);}  
		return false;
	}
	
	public static int getUserId(String username){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from user where username=?");   
		ps.setString(1,username);  
		ResultSet rs = ps.executeQuery();
		      
		if(rs.next()){
			int userid = rs.getInt("userid");
			return userid;
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return 0;
	}
	
	public static ArrayList<String> getMCQData(int mcqid){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from mcqquestion where mcqid=?");   
		ps.setInt(1,mcqid);  
		ResultSet rs = ps.executeQuery();
		      
		if(rs.next()){
			ArrayList<String> list = new ArrayList<String>();
			list.add(rs.getString("answer"));
			list.add(rs.getString("hint1"));
			list.add(rs.getString("hint2"));
			list.add(rs.getString("hint3"));
			list.add(rs.getString("feedback"));
			return list;
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return null;
	}
	
	public static ArrayList<String> getNumData(int numid){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from numquestion where numid=?");   
		ps.setInt(1,numid);  
		ResultSet rs = ps.executeQuery();
		      
		if(rs.next()){
			ArrayList<String> list = new ArrayList<String>();
			list.add(rs.getString("answer"));
			list.add(rs.getString("hint1"));
			list.add(rs.getString("hint2"));
			list.add(rs.getString("hint3"));
			list.add(rs.getString("feedback"));
			return list;
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return null;
	}
}
