<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.BoardVO, persistence.BoardDAO, java.util.List"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>커뮤니티 게시판</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script>
	var isEmpty = function(value) {
		if (value == "" || value == null || value == undefined) {
			return true
		} else {
			return false
		}
	};
</script>
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
			<%
			List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList");
			for (BoardVO vo : boardList) {
			%>
		</tr>
		<tr>
			<td><%=vo.getIdx()%></td>
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getContent()%></td>
			<td><%=vo.getWriter()%></td>
			<td><%=vo.getDate()%></td>
			<td> isEmpty(<%=vo.getNewdate()%>) </td>
		</tr>
		<%
		}
		%>
	</table>
</body>

</html>