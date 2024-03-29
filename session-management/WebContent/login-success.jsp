<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>
<body>
	<%
		String username = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies){
				if(cookie.getName().equals("session_cookie")){
					username = cookie.getValue();
					break;
				}
			}
			
			if(username == null){
				response.sendRedirect("/session-management/login.jsp");
			}
		}
	
	%>
	<h3>
		Hi <%= username %>
		<br/>Login successful.
	</h3>
	<br>
	<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>