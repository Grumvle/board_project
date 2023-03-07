<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.BoardVO, persistence.BoardDAO, java.util.List"%>
<%
BoardVO boardView = (BoardVO) request.getAttribute("boardPost");
%>
<%!String idx;%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>커뮤니티 게시판</title>

<script src="https://code.jquery.com/jquery-3.6.3.js"></script>

</head>

<body>
	<div>
		<h2><%=boardView.getIdx()%></h2>
		<h3><%=boardView.getTitle()%></h3>
		<h3><%=boardView.getWriter()%></h3>
		<h3><%=boardView.getDate()%></h3>
		<h3><%=boardView.getNewdate()%></h3>
		<h3><%=boardView.getContent()%></h3>
	</div>

	

	<button
		onclick="location.href='http://localhost:8787/JSP_BOARD/BoardServlet?cmd=read';">목록</button>
	<button
		onclick="location.href='http://localhost:8787/JSP_BOARD/BoardServlet?cmd=update&idx=<%=idx = boardView.getIdx()%>';">수정</button>
</body>

</html>