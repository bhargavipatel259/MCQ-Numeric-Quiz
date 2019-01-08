<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
    response.setHeader("Pragma", "no-cache");
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Answer Questions</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="address-bar">
<p>Please Choose Questions to Answer</p></div>
<div class="address-bar">
<div class="logout-section">
<input type="button" value="Log Out" onclick="location.href='LogoutServlet'"/>
</div></div>
<div class="window-bar">
<a href="MCQAnswer.jsp?mcqid=1"><img src="images/login.jpg" width="200" height="200"/></a>
<p>Multiple Choice Questions</p>
</div>
<div class="window-bar">
<a href="NumAnswer.jsp?numid=1"><img src="images/login.jpg" width="200" height="200"/></a>
<p>Numeric Questions</p>
</div>
</body>
</html>