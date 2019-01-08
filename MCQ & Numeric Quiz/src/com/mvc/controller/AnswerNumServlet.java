package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mvc.dao.AuthDao;


/**
 * Servlet implementation class AnswerNumServlet
 */
@WebServlet("/AnswerNumServlet")
public class AnswerNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		
    	int numid = Integer.parseInt((request.getParameter("numaid")));
		String numanswer = request.getParameter("numanswer");
		int attempt = 0;
		HttpSession session=request.getSession();
		if(session.getAttribute("nattempt") != null) {
			attempt = (int) session.getAttribute("nattempt");
		}
		attempt++;
        session.setAttribute("nattempt",attempt);
		 
		boolean result = AuthDao.checkNumAnswer(numid,numanswer);
		ArrayList<String> list = AuthDao.getNumData(numid);

		if(result){
			if(attempt==1){
				request.setAttribute("numMessage", "Your Answer is Correct!");
    			request.setAttribute("numFeedback", list.get(4).toString());
    			session.setAttribute("nattempt",0);
			}else if(attempt==2){
				request.setAttribute("numHint1", list.get(1).toString());
				request.setAttribute("numMessage", "Your Answer is Correct!");
    			request.setAttribute("numFeedback", list.get(4).toString());
    			session.setAttribute("nattempt",0);
			}else if(attempt==3){
				request.setAttribute("numHint1", list.get(1).toString());
				request.setAttribute("numHint2", list.get(2).toString());
				request.setAttribute("numMessage", "Your Answer is Correct!");
    			request.setAttribute("numFeedback", list.get(4).toString());
    			session.setAttribute("nattempt",0);
			}
			RequestDispatcher rd=request.getRequestDispatcher("NumAnswer.jsp?numid="+numid);  
			rd.include(request,response);
		}else{
			if(attempt==1){ 
				request.setAttribute("numHint1", list.get(1).toString());
			}else if(attempt==2){
				request.setAttribute("numHint1", list.get(1).toString());
				request.setAttribute("numHint2", list.get(2).toString());
			}else if(attempt>=3){
				String ans = list.get(0).toString();
    			request.setAttribute("numMessage", "All Wrong Attempts! Correct Answer is "+ans);
        		request.setAttribute("numFeedback", list.get(4).toString());
        		request.setAttribute("numHint1", list.get(1).toString());
				request.setAttribute("numHint2", list.get(2).toString());
    			request.setAttribute("numHint3", list.get(3).toString());
    			session.setAttribute("nattempt",0);
    		}
			RequestDispatcher rd=request.getRequestDispatcher("NumAnswer.jsp?numid="+numid);  
			rd.include(request,response);
		}
	}

}
