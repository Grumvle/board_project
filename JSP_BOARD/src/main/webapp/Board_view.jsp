<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.BoardVO, persistence.BoardDAO, java.util.List"%>
<%BoardVO boardView = (BoardVO) request.getAttribute("boardPost");
		%>
		<%! String idx; %>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>커뮤니티 게시판</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>

</head>

<body>


	<table border=1>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			
			<th>작성자</th>
			<th>게시날짜</th>
			<th>수정날짜</th>
		</tr>
		
		<tr>
			<td><%=boardView.getIdx()%></td>
			<td><%=boardView.getTitle()%></td>
			<td><%=boardView.getWriter()%></td>
			<td><%=boardView.getDate()%></td>
			<td><%=boardView.getNewdate()%></td>
		</tr>
		<tr>
		<th>내용</th>
		</tr>
		<tr>
			<td><%=boardView.getContent()%></td>
		</tr>
		
		
		
	</table>
	<button onclick="location.href='http://localhost:8787/JSP_BOARD/BoardServlet?cmd=read';">목록</button>
	<button onclick="location.href='http://localhost:8787/JSP_BOARD/BoardServlet?cmd=updateRead&idx=<%= idx =boardView.getIdx()%>';">수정</button>
	<button onclick="location.href='http://localhost:8787/JSP_BOARD/BoardServlet?cmd=delete';">삭제</button>
</body>

</html>