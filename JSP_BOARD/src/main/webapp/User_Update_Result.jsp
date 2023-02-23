<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보수정 결과</title>
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
</head>
<body>
	<header>[ 회원님의 정보가 수정되셨습니다. ]</header>
	<p id=sect><%=request.getAttribute("message")%><br>
	<div>
		<%
		MemberVO member = (MemberVO) request.getAttribute("member");
		%>
		<table>
			<tr>
				<th>아이디</th>
				<th><%=member.getId()%></th>
<!--  -->
			</tr>
			<tr>
				<th>이름</th>
				<th><%=member.getName()%></th>

			</tr>
			<tr>
				<th>비밀번호</th>
				<th><%=member.getPwd()%></th>

			</tr>
			<tr>
				<th>전화번호</th>
				<th><%=member.getPhone()%></th>
			</tr>
			<tr>
				<th>주소</th>
				<th><%=member.getAddr()%></th>
			</tr>

		</table>
	</div>



</body>
</html>