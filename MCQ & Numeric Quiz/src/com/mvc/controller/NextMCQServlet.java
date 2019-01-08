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
 * Servlet implementation class NextMCQServlet
 */
@WebServlet("/NextMCQServlet")
public class NextMCQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextMCQServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mcqid = Integer.parseInt((request.getParameter("mcqid")));
		boolean result = AuthDao.checkMCQLast(mcqid);
		
		if(result){
			request.setAttribute("mcqMessage", "This is last question!");
			request.getSession().setAttribute("lastmsg", "last");
			RequestDispatcher rd=request.getRequestDispatcher("MCQAnswer.jsp?mcqid="+mcqid);  
			rd.include(request,response);
		}else{
			if(request.getSession().getAttribute("lastmsg") == "last"){
				mcqid--;
				request.setAttribute("mcqMessage", "There are no more questions!");
				request.getSession().setAttribute("lastmsg", "first");
				RequestDispatcher rd=request.getRequestDispatcher("MCQLast.jsp?mcqid="+mcqid);  
				rd.include(request,response);
			}else{
				RequestDispatcher rd=request.getRequestDispatcher("MCQAnswer.jsp?mcqid="+mcqid);  
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
