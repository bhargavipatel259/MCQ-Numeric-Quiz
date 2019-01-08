package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.RegisterDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			String usrname = request.getParameter("username");
			String pswd = RegisterDao.Encryption_sha256(request.getParameter("password")); //PasswordEncryption using SHA-256
			String role1 = request.getParameter("role");
			String f_name = null;
			String l_name = null;
			String u_name = null;
			String passwd = null;
			String role = null;
			String sql = "select * from  icsi518_hw4f.UserTable where u_name =? and passwd = ? and role = ?";   //sql query to select values from database
			
			//String ICSI518_DB_HOST = System.getenv("ICSI518_DB_HOST");
			//String ICSI518_DB_PORT = System.getenv("ICSI518_DB_PORT");
			//String ICSI518_DB = System.getenv("ICSI518_DB");
			//String ICSI518_DB_USER = System.getenv("ICSI518_DB_USER");
			//String ICSI518_DB_PASSWD = System.getenv("ICSI518_DB_PASSWD");
			
			/*MessageDigest md = MessageDigest.getInstance("SHA-256");
			String ps = null;
			byte[] hash = md.digest(ps.getBytes(StandardCharsets.UTF_8));
			ps = Base64.getEncoder().encodeToString(hash);
			*/

			Class.forName("com.mysql.jdbc.Driver");
			
			//connecting to database using "icsi518" as userid and "secretICSI518" as password 
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icsi518_hw4f","icsi518","secretICSI518"); 
			
			
			
			
			//Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://"+ICSI518_DB_HOST+":"+ICSI518_DB_PORT+"/"+ICSI518_DB, ICSI518_DB_USER, ICSI518_DB_PASSWD);
			
			PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql);

			ps1.setString(1, usrname);
			ps1.setString(2, pswd);
			ps1.setString(3, role1);
			ResultSet rs = (ResultSet) ps1.executeQuery();
			System.out.println(rs.toString());
			System.out.println("Existing Values in Database : ");
			PrintWriter pw = response.getWriter();
			
			
			while (rs.next()) {
				u_name = rs.getString("u_name");
				passwd = rs.getString("passwd");
				role = rs.getString("role");
				f_name = rs.getString("f_name");
				l_name = rs.getString("l_name");

				int count=0;
				System.out.println("Iteration Count" + count++ + "\n" + u_name + " : " + passwd + " as " + role);
				System.out.println(f_name + " " + l_name);

				if (usrname.equals(u_name) && pswd.equals(passwd) && role1.equals(role)) {
					HttpSession session = request.getSession();
					session.setAttribute("role", role);
					session.setAttribute("username", usrname);
					session.setMaxInactiveInterval(30); //15 seconds
					response.sendRedirect("LoginSuccess.jsp");
				}

			}
				if (!usrname.equals(u_name) || !pswd.equals(passwd) || !role1.equals(role))  {
					System.out.println("Inside else LOOP");
					request.setAttribute("Error", "Invalid credentials, Try Logging In Again ! ");
					RequestDispatcher req = request.getRequestDispatcher("/Login.jsp");
					req.include(request, response);
					return;
				}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
