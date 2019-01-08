<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignUp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">


</head>
<body>
<h3 align="justify"> REGISTER HERE ! </h3>
	<div class="container">
		<div class="row">
	
			<form action="RegisterServlet" class="form-inline" method="post">
				<div class="form-group">
				
					<label>FIRST NAME</label> <input
						type="text" name="fname" class="form-control"
						 placeholder="xyz" >
				</div>
				<br/>
				<br/>
				<div class="form-group">
					<label >LAST NAME</label> <input
						type="text" name="lname" class="form-control"
						 placeholder="abc">
				</div>
				<br/>
				<br/>
				
				<div class="form-group">
					<label >USERNAME</label> <input type="text"
						name="uname" class="form-control" 
						placeholder="xyz_abc" >
				</div>
				
				<br/>
				<br/>
				
				<div class="form-group">
					<label >PASSWORD</label> <input
						type="password" name="passwd" class="form-control"
						 placeholder="Enter Password" >
				</div>
				<br/>
				<br/>
				<div class="form-group">
					<label >CONFIRM PASSWORD</label> <input
						type="password" name="confirmpasswd" class="form-control"
						 placeholder="Confirm Password"  >
				</div>
				
				<br/>
				<br/>
				
				<label > ROLE: </label>
				<td>
						<select name="role" >
						<option value="Select">--SELECT ROLE--</option>
						<option value="SUPPLIER">SUPPLIER</option>
						<option value="CUSTOMER">CUSTOMER</option>
						</select>
				</td>
				 <br /> <br />
				<button type="submit" class="btn btn-default" value="submit" onclick="return Validate()">Submit</button>
			</form>
			<h5 align="center">
			<font size = "5" color = "red"> ${Error} </font>
			</h5>
			<br/>

				<c:remove var="message" scope="session" />

			</h3>
		</div>
		
	</div>

		<script type="text/javascript">
		
    function Validate() {
        var password = document.getElementById("passwd").value;
        var confirmPassword = document.getElementById("confirmpasswd").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }

</body>
</html>