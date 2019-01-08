<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<h1>LOGIN HERE !</h1>
 
<input type="submit" value="Profile" class="btn btn-success" name="submitButton" onclick="javascript:return DisplayMessage();" />

 
<header align="left">

</header>
	<div class="container">
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<form action="LoginServlet" method="POST">

					<div class="form-group">
						<label>Username</label>
						 <input type="text"
							class="form-control" name="username" placeholder="Enter Username" required
							oninvalid="this.setCustomValidity('Username Required')"
							oninput="setCustomValidity('')" />
					</div>

					<div class="form-group">
						<label>Password</label> 
						<input
							type="password" class="form-control" name="password"
							placeholder="Enter Password" required
							oninvalid="this.setCustomValidity('Password Required')"
							oninput="setCustomValidity('')" />
					</div>

					<td>ROLE :</td>
				<td>
						<select name="role">
						<option value="Select">--SELECT ROLE--</option>
						<option value="SUPPLIER">SUPPLIER</option>
						<option value="CUSTOMER">CUSTOMER</option>
						</select>
				</td>
					</select> <br/> <br/> <input type="submit" class="btn btn-default"
						value="submit" />

						<h4 align="center">${Error}</h4>
						<c:remove var="message" scope="session" /> 
					
					<a class="btn btn-default" href="Register.jsp" role="button"> Click
						here to register!</a>
				</form>
		
			</div>
			<div class="col-lg-3"></div>
		</div>

	</div>
	
	<script>
	
    function DisplayMessage() {
        var result = confirm(" You Need To Login First ! ");
        if (result) {
            return true;
        } else {
            return false;
        }
    }
   </script>
	
		
</body>
</html>