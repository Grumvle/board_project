<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.*"%>
<% %>
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

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="addr.js"></script>
<title>회원정보 수정</title>
</head>
<body>
	<p id=sect>커뮤니티 가입을 축하합니다.</p>
	<div align="center">
		<HR>
		<form
			action="http://localhost:8787/JSP_BOARD/MemberServlet?cmd=update" method="post">

			<fieldset>
				<legend>개인정보 수정</legend>
				<ul>
					<li>아이디 : <input type="text" name="userid"
						value=<%=session.getAttribute("id")%> readonly>
					<li>
					<li>비밀번호 : <input type="password" name="userpasswd"
						value=<%=session.getAttribute("pw")%>>
					<li>
					<li>이름 : <input type="text" name="username"
						value=<%=session.getAttribute("name")%> autofocus>
					<li>
					<li>전화번호 : <input type="text" name="userphone"
						value=<%=session.getAttribute("phone")%>>
					<li>
					<li>주소 : <input name="addr" type="text" id="postcode"
						placeholder="우편번호" readonly value='<%=session.getAttribute("addr")%>'> 
						<input type="button" id="postcode_button" onclick="open_Postcode()" value="우편번호 찾기" ><br>
						<input name="addr1" type="text" id="road_address" placeholder="도로 주소" readonly value ='<%=session.getAttribute("addr1")%>'><br> 
						<input name="addr2" type="text" id="extra_address" placeholder="상세 주소" value='<%=session.getAttribute("addr2")%>'><br>
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