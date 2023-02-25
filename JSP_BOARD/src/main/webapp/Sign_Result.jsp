<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
if (session.getAttribute("id") == null) {
	response.sendRedirect("Sign_out.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<h1><%=session.getAttribute("id")%>님 <small>반갑습니다.</small>
	</h1>
	<a href="Sign_out.jsp">로그아웃</a>
	<!--  -->
	<a href="User_update.jsp">회원정보 수정 </a>

	<!-- 회원 탈퇴 시  -->
	<a href="Delete_User.jsp" target="_self">회원 탈퇴 </a>
	<a href="http://localhost:8787/JSP_BOARD/BoardServlet?cmd=read" target="_self">게시글 목록 </a>
	<a href="Board_write.jsp" target="_self">게시글 작성 </a>
	
</body>
</html>