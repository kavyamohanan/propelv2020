<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin:User Registration</title>
<script>
function validate() {
	var fullname = document.form.fullName.value;
	var email = document.form.email.value;
	var username = document.form.userName.value;
	var password = document.form.passWord.value;
	var conpassword = document.form.conpassword.value;

	if (fullname == null || fullname == "") {
		alert("Full Name can't be blank");
		return false;
	} else if (email == null || email == "") {
		alert("Email can't be blank");
		return false;
	} else if (username == null || username == "") {
		alert("Username can't be blank");
		return false;
	} else if (password.length < 6) {
		alert("Password must be at least 6 characters long.");
		return false;
	} else if (password != conpassword) {
		alert("Confirm Password should match with the Password");
		return false;
	}
}

</script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css"></link>

</head>
<%
	//in case if admin session is not set,redirect to login page
	if(request.getSession(false).getAttribute("Admin") == null){
%>
	<jsp:forward page = "/JSP/Login.jsp"></jsp:forward>
<%
	}
%>

<body style="background:#e6ecff">
<br>
<center><h1 style="color: #0033cc">Registration Application Using MVC and ORACLE</h1></center>

Welcome <b><%=request.getAttribute("userName") %></b>

<div style="text-align:right">
	<a href = "<%=request.getContextPath() %>/JSP/List.jsp">List</a>&nbsp;&nbsp;
	<a href = "<%=request.getContextPath() %>/LogoutServlet">Logout</a>
</div>

<hr>

<!--  -->

<c:if test="${user !=null}">
					<form action="update" method="post" onsubmit="return validate()">	
					
				</c:if>
				
				<c:if test="${user == null}">
					<form action="insert" method="post" onsubmit="return validate()">
				</c:if>
				
				<caption>
					<h2>
						<c:if test="${user != null}">
							Edit User
						</c:if>
						<c:if test="${user == null}">
							Add New User
						</c:if>
					</h2>
				</caption>
				
				
<!--  -->

<!--  <form name ="form"  action="RegisterServlet" method="post" onsubmit="return validate()">-->
	<table align="center">
	
			<tr><c:if  test="${user != null}">
					<td><input type="hidden" name="id" value="<c:out value='${user.slNo}'/>"/></td>
				</c:if></tr>
			<tr>
				<td>Full Name</td>
				<td><input type="text" class="form-control" name="fullName" autocomplete="off" value="<c:out value='${user.fullName}'/>" required/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" class="form-control" name="email" value="<c:out value='${user.email }'/>"required/></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" class="form-control" name="userName" value="<c:out value='${user.userName}'/>" required/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" class="form-control" name="passWord" value="<c:out value='${user.password}'/>" required/></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" class="form-control" name="conpassword" required/></td>
			</tr>
			
			<tr>
				<td>Role</td>
				<!--<td><input type="" class="form-control" name="role" required/></td>-->
				<td><select name="role" class="form-control" value="<c:out value='${user.role}'/>" required>
					<option value="0">-Select-</option>
					<option>User</option>
					<option>Admin</option>
					<option>Editor</option>	
				</select></td>
			</tr>
			<tr>
			<td>Gender</td>
			<td><input type="radio" value="male" name="gender" id="male">Male
			<input type="radio" value="female" name="gender" id="female">Female
			<input type="radio" value="other" name="gender" id="other">Other</td>
			</tr>
			<tr>
			<td>Is Active</td>
			<td><input type="checkbox"  value="y" name="isact" required>Yes</td>
			</tr>
			<tr>
			<td>Registration Date</td>
			<td><input type="date" placeholder="dd/mm/yyyy" value="<c:out value='${user.regDate}'/>" class="form-control" name="regdate" required></td>
			</tr>
			<tr>
				<td><%=(request.getAttribute("errMessage") == null) ? ""
					: request.getAttribute("errMessage")%></td>
			</tr>
			<tr>
	
				<td><input type="submit"  class="btn btn-info" value="Register"></input>&nbsp;&nbsp;&nbsp;
				<input type="reset" class="btn btn-primary" value="Reset"></input></td>
			</tr>
		</table>

</form>

</body>
</html>