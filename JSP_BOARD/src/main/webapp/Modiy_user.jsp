<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.IOException"%>

<%-- <%
// 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
if (session.getAttribute("id") == null) {
	response.sendRedirect("Sign_out.jsp");
}
%>
 --%>

<%!Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String member_name = "";
	String member_id = "";
	String member_pwd = "";
	String member_phone = "";
	String member_addr = "";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify User</title>
</head>
<body>
<%
	member_id =(String)session.getAttribute("id");



%>
</body>
</html>