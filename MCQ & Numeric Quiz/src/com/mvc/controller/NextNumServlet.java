package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.dao.AuthDao;


/**
 * Servlet implementation class NextNumServlet
 */
@WebServlet("/NextNumServlet")
public class NextNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numid = Integer.parseInt((request.getParameter("numid")));
		boolean result = AuthDao.checkNumLast(numid);
		
		if(result){
			request.setAttribute("numMessage", "This is last question!");
			request.getSession().setAttribute("lastmsgs", "last");
			RequestDispatcher rd=request.getRequestDispatcher("NumAnswer.jsp?numid="+numid);  
			rd.include(request,response);
		}else{
			if(request.getSession().getAttribute("lastmsgs") == "last"){
				numid--;
				request.setAttribute("numMessage", "There are no more questions!");
				request.getSession().setAttribute("lastmsgs", "first");
				RequestDispatcher rd=request.getRequestDispatcher("NumLast.jsp?numid="+numid);  
				rd.include(request,response);
			}else{
				RequestDispatcher rd=request.getRequestDispatcher("NumAnswer.jsp?numid="+numid);  
				rd.include(request,response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
