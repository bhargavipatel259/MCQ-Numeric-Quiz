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
 * Servlet implementation class AnswerMCQServlet
 */
@WebServlet("/AnswerMCQServlet")
public class AnswerMCQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerMCQServlet() {
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
		
        	int mcqid = Integer.parseInt((request.getParameter("mcqaid")));
    		String mcqanswer = request.getParameter("mcqanswers");
    		int attempt = 0;
    		HttpSession session=request.getSession();
    		if(session.getAttribute("attempt") != null) {
    			attempt = (int) session.getAttribute("attempt");
    		}
    		attempt++;
            session.setAttribute("attempt",attempt);
    		 
    		boolean result = AuthDao.checkMCQAnswer(mcqid,mcqanswer);
    		ArrayList<String> list = AuthDao.getMCQData(mcqid);

    		if(result){
    			if(attempt==1){
    				request.setAttribute("mcqMessage", "Your Answer is Correct!");
        			request.setAttribute("mcqFeedback", list.get(4).toString());
        			session.setAttribute("attempt",0);
    			}else if(attempt==2){
    				request.setAttribute("mcqHint1", list.get(1).toString());
    				request.setAttribute("mcqMessage", "Your Answer is Correct!");
        			request.setAttribute("mcqFeedback", list.get(4).toString());
        			session.setAttribute("attempt",0);
    			}else if(attempt==3){
    				request.setAttribute("mcqHint1", list.get(1).toString());
    				request.setAttribute("mcqHint2", list.get(2).toString());
    				request.setAttribute("mcqMessage", "Your Answer is Correct!");
        			request.setAttribute("mcqFeedback", list.get(4).toString());
        			session.setAttribute("attempt",0);
    			}
    			RequestDispatcher rd=request.getRequestDispatcher("MCQAnswer.jsp?mcqid="+mcqid);  
    			rd.include(request,response);
    		}else{
    			if(attempt==1){ 
    				request.setAttribute("mcqHint1", list.get(1).toString());
    			}else if(attempt==2){
    				request.setAttribute("mcqHint1", list.get(1).toString());
    				request.setAttribute("mcqHint2", list.get(2).toString());
    			}else if(attempt>=3){
    				String ans = list.get(0).toString();
        			request.setAttribute("mcqMessage", "All Wrong Attempts! Correct Answer is "+ans);
            		request.setAttribute("mcqFeedback", list.get(4).toString());
            		request.setAttribute("mcqHint1", list.get(1).toString());
    				request.setAttribute("mcqHint2", list.get(2).toString());
        			request.setAttribute("mcqHint3", list.get(3).toString());
        			session.setAttribute("attempt",0);
        		}
    			RequestDispatcher rd=request.getRequestDispatcher("MCQAnswer.jsp?mcqid="+mcqid);  
    			rd.include(request,response);
    		}
    		
    }

}
