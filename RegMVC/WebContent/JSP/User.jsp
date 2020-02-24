<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	//incase, user session is not set ,redirect to login page
	if((request.getSession(false).getAttribute("User") ==null)){
%>
<jsp:forward page="/JSP/Login.jsp"></jsp:forward>
<%} %>
<body>

<center><h2>User's Home</h2></center>

Welcome&nbsp;<%=request.getAttribute("userName") %>
<div style="text-align:right">
	<a href="<%= request.getContextPath()%>/LogoutServlet">Logout</a>
	<hr>
</div>

</body>
</html>