<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Service Programming Homework</title>
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
</head>
<body>
	<header> 2021 KPU Web Service Programming Community</header>
	
	<div>
		<%
		MemberVO member = (MemberVO) request.getAttribute("member");
		%>
		<table>
			<tr>
				<th>이름</th>
				<th><%=member.getName()%></th>

			</tr>
			<tr>
				<th>아이디</th>
				<th><%=member.getId()%></th>
<!--  -->
			</tr>
			<tr>
				<th>비밀번호</th>
				<th><%=member.getPwd()%></th>

			</tr>
			<tr>
				<th>연락처</th>
				<th><%=member.getPhone()%></th>
			</tr>
			<tr>
				<th>주소</th>
				<th><%=member.getAddr()%></th>
			</tr>



		</table>
	</div>
	<div>
		<p>
			<br> <!-- <a
				href="http://localhost:8787/JSP_BOARD/MemberServlet?cmd=list"
				target="_self"> <strong>전체 회원 목록 보기 </strong></a> -->
		</p>
	</div>


</body>
</html>