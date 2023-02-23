<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.MemberVO, persistence.MemberDAO, java.util.List"%>
<!DOCTYPE html">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MemberList</title>
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
</head>
<body>
	<p id=sect>삭제하려는 회원의 아이디를 선택해주세요.</p>
	<div align="center">
		<H2>[[ 회원 삭제 ]]</H2>
		<HR>
		<a href="http://localhost:8787/JSP_BOARD/Main.jsp" target="_self">메인
			페이지 이동 </a>
		<table>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>비밀번호</td>
				<td>전화번호</td>
				<td>주소</td>
			<tr>
				<%
				List<MemberVO> memberList = (List<MemberVO>) request.getAttribute("memberList");
				for (MemberVO vo : memberList) {
				%>
			
			<tr>
				<td><a
					href="http://localhost:8787/JSP_BOARD/AdminServlet?cmd=delete&id=<%=vo.getId()%>"
					target="_self"><%=vo.getId()%></a></td>
				<td><%=vo.getName()%></td>
				<td><%=vo.getPwd()%></td>
				<td><%=vo.getPhone()%></td>
				<td><%=vo.getAddr()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>