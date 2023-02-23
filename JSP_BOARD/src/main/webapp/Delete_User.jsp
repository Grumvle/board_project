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
<title>탈퇴하려는 회원의 정보</title>
</head>
<body>
	<p id=sect>회원의 정보를 수정합니다.</p>
	<div align="center">
		<HR>
		<form
			action="http://localhost:8787/JSP_BOARD/MemberServlet?cmd=delete"
			method="post">

			<fieldset>
				<legend> [ 회원 탈퇴 ] </legend>
				<ul>
					<li>아이디 : <input type="text" name="id"
						value=<%=session.getAttribute("id")%> readonly>
					<li>
				</ul>
			</fieldset>
			<br>
			<fieldset>
				<!-- 전화면으로 돌아가는 버튼도 만들어야 합니다. -->
				<input type="submit" name="submit" value="회원 탈퇴">
				
			</fieldset>
		</form>

	</div>
</body>
</html>