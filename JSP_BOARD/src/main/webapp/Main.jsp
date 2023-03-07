<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="http://localhost:8787/JSP_BOARD/Sign_in.jsp" target="_self">로그인</a>
	<a href="http://localhost:8787/JSP_BOARD/BoardServlet?cmd=read2" target="_self">게시판 목록</a>
	<a href="http://localhost:8787/JSP_BOARD/Sign_up.jsp" target="_self">회원가입</a>
	<button onclick="location.href='http://localhost:8787/JSP_BOARD/BoardServlet?cmd=read';">커뮤니티 게시판</button>
</body>
</html> 