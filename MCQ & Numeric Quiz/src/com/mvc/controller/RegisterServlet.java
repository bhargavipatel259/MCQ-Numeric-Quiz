package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String frstname = request.getParameter("fname");
		String lstname = request.getParameter("lname");
		String usrname = request.getParameter("uname");
		String pswd = (request.getParameter("passwd"));
		String cps = (request.getParameter("confirmpasswd"));
		String r = request.getParameter("role");

		
		RegisterBean rb = new RegisterBean();
		rb.setFname(frstname);
		rb.setLname(lstname);
		rb.setUname(usrname);
		rb.setPasswd(pswd);
		rb.setRole(r);
		

		
		if (rb.getFname().equals("") && rb.getLname().equals("") && rb.getUname().equals("") && rb.getPasswd().equals("")) {
			request.setAttribute("Error", "All Fields are Required");
			RequestDispatcher reqdis = request.getRequestDispatcher("/Register.jsp");
			reqdis.include(request, response);
		}
		 else if (rb.getFname().equals("")) {
			request.setAttribute("Error", "Please enter first name ");
			RequestDispatcher reqdis = request.getRequestDispatcher("/Register.jsp");
			reqdis.include(request, response);
		} else if (rb.getLname().equals("")) {
			request.setAttribute("Error", "Please enter last name ");
			RequestDispatcher reqdis = request.getRequestDispatcher("/Register.jsp");
			reqdis.include(request, response);
		}

		else if (rb.getUname().equals("")) {
			request.setAttribute("Error", "Please enter username,username cannot be blank");
			RequestDispatcher reqdis = request.getRequestDispatcher("/Register.jsp");
			reqdis.include(request, response);
		}

		else if (rb.getPasswd().equals("")) {
			request.setAttribute("Error", "Please enter Password, Password cannot be blank");
			RequestDispatcher reqdis = request.getRequestDispatcher("/Register.jsp");
			reqdis.include(request, response);
		} 
		else if (!pswd.equals(cps)) {
			request.setAttribute("Error", "password and confirm password must match");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		} 
		else {
			RegisterDao rd = new RegisterDao();

			String reg_user = rd.registerUser(rb);

			if(reg_user.equalsIgnoreCase("Success"))  {
				request.setAttribute("Error", "Registration Successful !!");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			} else {
				request.setAttribute("Error", "USERNAME ALREADY EXISTS !!");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		}
	}
}
