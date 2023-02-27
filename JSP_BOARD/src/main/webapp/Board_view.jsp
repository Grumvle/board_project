<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.BoardVO, persistence.BoardDAO, java.util.List"%>
<%BoardVO boardView = (BoardVO) request.getAttribute("boardPost");
		%>
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
			<th>내용</th>
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
			<td><%=boardView.getContent()%></td>
		</tr>
	</table>
</body>

</html>