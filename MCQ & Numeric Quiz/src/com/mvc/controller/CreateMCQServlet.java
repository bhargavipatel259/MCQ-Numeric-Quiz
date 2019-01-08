package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.dao.AuthDao;

/**
 * Servlet implementation class CreateMCQServlet
 */
@WebServlet("/CreateMCQServlet")
public class CreateMCQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMCQServlet() {
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
        PrintWriter out=response.getWriter();  
          
        String question=request.getParameter("mcqques");
        String choicea=request.getParameter("choicea");
        String choiceb=request.getParameter("choiceb");
        String choicec=request.getParameter("choicec");
        String choiced=request.getParameter("choiced");
        String mcqanswer=request.getParameter("mcqanswer");
        String mcqhint1=request.getParameter("mcqhint1");
        String mcqhint2=request.getParameter("mcqhint2");
        String mcqhint3=request.getParameter("mcqhint3");
        String mcqfeedback=request.getParameter("mcqfeedback");
        
        boolean checkquestion = AuthDao.checkMCQQuestion(question);
        
        if(checkquestion){ 
        	boolean status = AuthDao.enterNewMCQQuestion(question,choicea,choiceb,choicec,choiced,mcqanswer,mcqhint1,mcqhint2,mcqhint3,mcqfeedback);
            
            if(status){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('MCQ Added Successfully!')"); 
                out.println("location='MCQQues.jsp';");
                out.println("</script>");
                RequestDispatcher rd=request.getRequestDispatcher("MCQQues.jsp");  
                rd.include(request,response); 
            }else{ 
            	out.println("<script type=\"text/javascript\">");
                out.println("alert('Error Adding Question!')"); 
                out.println("location='MCQQues.jsp';");
                out.println("</script>");
                RequestDispatcher rd=request.getRequestDispatcher("MCQQues.jsp");  
                rd.include(request,response); 
            }
        }else{
        	request.setAttribute("errMessage3", "Question already exists");
        	RequestDispatcher rd=request.getRequestDispatcher("MCQQues.jsp");  
            rd.include(request,response); 
        }
	}

}
