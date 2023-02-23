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
<title>회원정보 수정</title>
</head>
<body>
	<h1><%=session.getAttribute("name")%>님 <small>반갑습니다.</small>
	</h1>
	<h1><%=session.getAttribute("id")%>님 <small>반갑습니다.</small>
	</h1>
	<h1><%=session.getAttribute("pw")%>님 <small>반갑습니다.</small>
	</h1>
	<h1><%=session.getAttribute("phone")%>님 <small>반갑습니다.</small>
	</h1>
	<h1><%=session.getAttribute("addr")%>님 <small>반갑습니다.</small>
	</h1>
</body>
</html>