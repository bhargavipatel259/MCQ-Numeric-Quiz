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
<title>Numeric Questions</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<script type="text/javascript"> 
function validationNum(){
var numques = document.form.numques.value; 
var numans = document.form.numanswer.value;
var numhint1 = document.form.numhint1.value;
var numhint2 = document.form.numhint2.value;
var numhint3 = document.form.numhint3.value;
var numfeedback = document.form.numfeedback.value;
if ((numques==null || numques=="") && (numans==null || numans=="") && (numhint1==null || numhint1=="") && (numhint2==null || numhint2=="")
		&& (numhint3==null || numhint3=="") && (numfeedback==null || numfeedback=="")){ 
	alert("Please fill all details"); 
	return false; 
}else if(numques==null || numques==""){ 
	alert("Please enter Question"); 
	return false; 
}else if(numans==null || numans==""){
	alert("Please enter Answer"); 
	return false;
}else if(numhint1==null || numhint1==""){
	alert("Please enter Hint 1"); 
	return false;
}else if(numhint2==null || numhint2==""){
	alert("Please enter Hint 2"); 
	return false;
}else if(numhint3==null || numhint3==""){
	alert("Please enter Hint 3"); 
	return false;
}else if(numfeedback==null || numfeedback==""){
	alert("Please enter Feedback"); 
	return false;
}
}
</script>
<div class="address-bar">
<p>Please Create Numeric Questions</p></div>
<div class="address-bar">
<div class="logout-section">
<input type="button" value="Log Out" onclick="location.href='LogoutServlet'"/>
</div></div>
<div class="question-page">
  <div class="question-form">
  <p class="login-title">Numeric Questions</p>
  <p id="errmsgn" class="errmessage"><%=(request.getAttribute("errMessage4") == null) ? "" : request.getAttribute("errMessage4")%></p>
    <form class="login-form" name="form" action="CreateNumQServlet" method="post" onsubmit="return validationNum()">
    <input type="text" name="numques" class="class-input" placeholder="Enter Question"/>
    <input type="text" name="numanswer" class="class-input" placeholder="Enter Answer"/>
	  <input type="text" name="numhint1" class="class-input" placeholder="Enter Hint 1"/>
      <input type="text" name="numhint2" class="class-input" placeholder="Enter Hint 2"/>
      <input type="text" name="numhint3" class="class-input" placeholder="Enter Hint 3"/>
      <input type="text" name="numfeedback" class="class-input" placeholder="Enter Feedback"/>
      <input type="submit" class="class-button" value="Submit & Add New"/>
      <input type="button" class="class-button" value="Done" onclick="location.href='Success.jsp'"/>
    </form>
  </div>
</div>
</body>
</html>