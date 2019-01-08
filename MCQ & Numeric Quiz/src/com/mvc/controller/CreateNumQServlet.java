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
 * Servlet implementation class CreateNumQServlet
 */
@WebServlet("/CreateNumQServlet")
public class CreateNumQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNumQServlet() {
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
          
        String question=request.getParameter("numques");
        String numanswer=request.getParameter("numanswer");
        String numhint1=request.getParameter("numhint1");
        String numhint2=request.getParameter("numhint2");
        String numhint3=request.getParameter("numhint3");
        String numfeedback=request.getParameter("numfeedback");
        
        boolean checkquestion = AuthDao.checkNumQuestion(question);
        
        if(checkquestion){ 
        	boolean status = AuthDao.enterNewNumQuestion(question,numanswer,numhint1,numhint2,numhint3,numfeedback);
            
            if(status){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Numeric Question Added Successfully!')"); 
                out.println("location='NumQues.jsp';");
                out.println("</script>");
                RequestDispatcher rd=request.getRequestDispatcher("NumQues.jsp");  
                rd.include(request,response); 
            }else{ 
            	out.println("<script type=\"text/javascript\">");
                out.println("alert('Error Adding Question!')"); 
                out.println("location='NumQues.jsp';");
                out.println("</script>");
                RequestDispatcher rd=request.getRequestDispatcher("NumQues.jsp");  
                rd.include(request,response); 
            }
        }else{
        	request.setAttribute("errMessage4", "Question already exists");
        	RequestDispatcher rd=request.getRequestDispatcher("NumQues.jsp");  
            rd.include(request,response); 
        }
	}

}
