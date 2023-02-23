<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
if (session.getAttribute("id") == null) {
	response.sendRedirect("Sign_out.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!--  -->
<title>회원정보 수정</title>
</head>
<body>
	<p id=sect>회원의 정보를 수정합니다.</p>
	<div align="center">
		<HR>
		<form
			action="http://localhost:8787/JSP_BOARD/MemberServlet?cmd=update"
			method="post">

			<fieldset>
				<legend>개인정보 수정</legend>
				<ul>
					<li>아이디 : <input type="text" name="userid"
						value=<%=session.getAttribute("id")%> readonly>
					<li>
					<li>비밀번호 : <input type="text" name="userpasswd"
						value=<%=session.getAttribute("pw")%>>
					<li>
					<li>이름 : <input type="text" name="username"
						value=<%=session.getAttribute("name")%> autofocus>
					<li>
					<li>전화번호 : <input type="text" name="userphone"
						value=<%=session.getAttribute("phone")%>>
					<li>
					<li>주소 : <input type="text" name="useraddr"
						value=<%=session.getAttribute("addr")%>>
					<li>
				</ul>
			</fieldset>
			<br>
			<fieldset>
				<input type="submit" name="submit" value="최종 수정"> <input
					type="reset" name="reset" value="다시 작성">
			</fieldset>
		</form>

	</div>
</body>
</html>