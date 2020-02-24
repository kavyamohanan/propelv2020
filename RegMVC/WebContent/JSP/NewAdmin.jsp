<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
		<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #aa66cc">
		<div>
			<a href="" class="navbar-brand">User Management App</a>
		</div>
		
		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
		</ul>
		</nav>
	</header>

	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user !=null}">
					<form action="update" method="post">	
					
				</c:if>
				
				<c:if test="${user == null}">
					<form action="insert" method="post">
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
				
				<c:if  test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.slNo}'/>"/>
				</c:if>
				
				<fieldset class="form-group">
					<label>Full Name</label>
					<input type="text" class="form-control" name="fullName" autocomplete="off" value="<c:out value='${user.fullName}'/>" required/>
				</fieldset>
				
				<fieldset>
					<label>Email</label>
					<input type="text" placeholder="Email" value="<c:out value='${user.email}'/>" class="form-control" name="email" required>
				</fieldset>
				
				<fieldset>
					<label>Email</label>
					<input type="text" placeholder="Email" value="<c:out value='${user.email}'/>" class="form-control" name="email" required>
				</fieldset>
				
				<fieldset>
					<label>Email</label>
					<input type="text" placeholder="Email" value="<c:out value='${user.email}'/>" class="form-control" name="email" required>
				</fieldset>
				
				<fieldset>
					<label>Username</label>
					<input type="text" class="form-control" name="userName" value="<c:out value='${user.userName}'/>" required/></td>
			</fieldset>
				
				<fieldset>
					<label>Password</label>
					<td><input type="password" class="form-control" name="passWord" value="<c:out value='${user.password}'/>" required/></td>
			</fieldset>
				
				<fieldset>
					<label>Confirm Password</label>
					<td><input type="password" class="form-control" name="conpassword" required/></td>
			</fieldset>
			
			<fieldset>
					<label>Password</label>
					<td><input type="password" class="form-control" name="passWord" value="<c:out value='${user.password}'/>" required/></td>
			</fieldset>
			
			<fieldset>
					<label>Password</label>
					<td><input type="password" class="form-control" name="passWord" value="<c:out value='${user.password}'/>" required/></td>
			</fieldset>
			
			<fieldset>
					<label>Password</label>
					<td><input type="password" class="form-control" name="passWord" value="<c:out value='${user.password}'/>" required/></td>
			</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>	
			</div>
		</div>
	</div>
		
</body>
</html>