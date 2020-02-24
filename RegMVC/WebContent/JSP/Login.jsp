<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css"></link>
</head>
<body>
	<form name="form" action="<%=request.getContextPath()%>/LoginServlet"
		method="post">
		<center>
			<h2>Login</h2><br>
		</center>
		<div class="md-form">
		<table align="center" >
	
			<tr>
				<td>Username</td>
				<td><input type="text" class="form-control" name="username" required/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" class="form-control" name="password" required/></td>
			</tr>
			<tr>
				<td><span style="color: red"><%=(request.getAttribute("errorMessage") == null) ? "": request.getAttribute("errorMessage")%></span></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-success" value="Login"></input>&nbsp;&nbsp;
				<input type="reset" class="btn btn-success" value="Reset"></input></td>
			</tr>
			
		</table>
		</div>
	</form>
</body>
</html>