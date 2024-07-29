<%@page language="java" import ="java.sql.*"%>
<%
request.setAttribute("logout", "Logged out successfully");
session.invalidate();
request.getRequestDispatcher("index.jsp").forward(request, response);
%>