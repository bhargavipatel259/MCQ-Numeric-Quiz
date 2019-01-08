<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HomePage</title>
</head>
<body>

	<%  
    if(session.getAttribute("username")== null){
    	response.sendRedirect("Login.jsp");
    }

	String role =  session.getAttribute("role").toString();            
          
%>
<h1>
	<h2 align = "center"> WELCOME !!</font></h2>
		<font color="RebeccaPurple"> <%= session.getAttribute("role")%> :<h3><%= session.getAttribute("username")%>!</h3>
		</font>
	</h1>
	
	<h3>
		ROLE: <font color="Crimson"> <%=session.getAttribute("role")%>
		</font>
	</h3>
	<% 
    		out.println(" <br> CURRENT TIME AT LOGIN IS : "  + new java.util.Date());         
	%>
<br/>
<br/>
<form name="myForm2" method="get" action="LogoutServlet">
		
	<div>
		<p style="float: left; font-size: 12pt; text-align: center; width: 30%; margin-right: 1%; margin-bottom: 0.5em;"><img src="questions.jpeg" style="width: 250px; height: 250px;"><br/><a href="CreateQues.jsp">Create Question </a></p>
		
		<!--  
			<img src="questions.jpeg"
				style="width: 150px; height: 150px;">
			
				<p><a href="CreateQuestions.jsp">Create Question </a></p>
		-->
			
			<p style="float: left; font-size: 12pt; text-align: center; width: 30%; margin-right: 1%; margin-bottom: 0.5em;"><img src="answers.png" style="width: 250px; height: 250px;"><br/><a href="AnswerQues.jsp">Answer Question </a></p>
			
		<!--  	
			<img src="answers.png"
				style="width: 150px; height: 150px;">
			
				<p><a href="AnswerQuestions.jsp">Answer Question</a></p>
		-->

		</div>
	<br/>
	<br>
	<br>
	<br>
	<a href="Logout.jsp"> <input type = "button" value="LOGOUT" style="vertical-align:bottom"></a>
	
	<h4 align="center">${Error}</h4>
						<c:remove var="message" scope="session" /> 
					
	</form>

</body>
</html>