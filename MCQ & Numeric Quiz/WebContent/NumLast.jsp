<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
    response.setHeader("Pragma", "no-cache");
%>
<%
    try {
        if ((session.getAttribute("username")).toString() == null || (session.getAttribute("role")).toString() == null) {
            response.sendRedirect("Login.jsp");
        }
    } catch (Exception e) {
        response.sendRedirect("Login.jsp");
    }
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Numerical Questions</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
int numid = Integer.parseInt((request.getParameter("numid")));
%>
<div class="address-bar">
<p>Please Answer Numerical Questions</p></div>
<div class="address-bar">
<div class="logout-section">
<input type="button" value="Log Out" onclick="location.href='LogoutServlet'"/>
</div></div>
 				<% Class.forName("com.mysql.jdbc.Driver");  
                
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/icsi518_hw4","root","root");  
  
                PreparedStatement ps=con.prepareStatement(
                "select * from numquestion where numid="+numid);        
                    
                ResultSet rs=ps.executeQuery();
                while (rs.next())
                {
                %>
                <p class="bolds">Q.<%= rs.getInt(1) %>: <%= rs.getString(2) %></p>
                <p class="bolds">Your Answer is: <input type="text" name="leisure"></p>
				<%
                }
                %>
				<p class="bolds">Hint 1: <span><%=(request.getAttribute("numHint1") == null) ? "" : request.getAttribute("numHint1")%></span></p>
                <p class="bolds">Hint 2: <span><%=(request.getAttribute("numHint2") == null) ? "" : request.getAttribute("numHint2")%></span></p>
                <p class="bolds">Hint 3: <span><%=(request.getAttribute("numHint3") == null) ? "" : request.getAttribute("numHint3")%></span></p>
                <p class="bolds">Feedback: <span><%=(request.getAttribute("numFeedback") == null) ? "" : request.getAttribute("numFeedback")%></span></p>
                <p class="bolds">Message: <span><%=(request.getAttribute("numMessage") == null) ? "" : request.getAttribute("numMessage")%></span></p>
                <input type="button" value="Submit">
                <input type="button" value="Next Question">
                <input type="button" value="Go to Main Page" onclick="location.href='Success.jsp'">                
</body>
</html>