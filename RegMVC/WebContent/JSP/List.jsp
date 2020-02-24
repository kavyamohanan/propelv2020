<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Management Application</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #0099CC">
			<div>
				<a href="" class="navbar-brand"> Registration MVC </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		
		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>SlNo</th>
						<th>Full Name</th>
						<th>Email</th>
						<th>UserName</th>
						<th>Password</th>
						<th>Active or not</th>
						<th>Role</th>
						<th>Gender</th>
						<th>Reg Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.slNo}" /></td>
							<td><c:out value="${user.fullName}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.userName}" /></td>
							<td><c:out value="${user.password}" /></td>
							<td><c:out value="${user.role}" /></td>
							<td><c:out value="${user.isActive}" /></td>
							<td><c:out value="${user.gender}" /></td>
							<td><c:out value="${user.regDate}" /></td>
							<td><a href="edit?id=<c:out value='${user.slNo}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=<c:out value='${user.slNo}' />">Delete</a></td>
						</tr>
					</c:forEach>
					
				</tbody>

			</table>
		</div>
	</div>

</body>
</html>