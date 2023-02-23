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
	<h1><%=session.getAttribute("id")%>님 <small> 관리자 페이지입니다.</small>
	</h1>
	<!--  -->
	<!-- 회원 탈퇴 시  -->
	<button onclick="location.href='http://localhost:8787/JSP_BOARD/AdminServlet?cmd=Member_List(Admin)';"
		>회원 삭제.</button>
	<button onclick="location.href='http://localhost:8787/JSP_BOARD/User_update(Admin).jsp';">회원정보 수정 </button>
	<button onclick="location.href='http://localhost:8787/JSP_BOARD/Sign_out.jsp';">관리자 로그아웃</button>
</body>
</html>