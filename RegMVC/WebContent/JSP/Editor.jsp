<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editor</title>
</head>
<%

//incase , if editor session is not set ,redirect to login page
	if((request.getSession(false).getAttribute("Editor") == null)){
%>
<jsp:forward page="/JSP/Login.jsp"></jsp:forward>
<%} %>
<body>
	
	<center><h2>Editor's Home</h2></center>
	
	Welcome
	<b><%=request.getAttribute("userName") %></b>
	<div style="text-align:right">
		<a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
	</div>
	<hr>
</body>
</html>