<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="model.BoardVO, persistence.BoardDAO, java.util.List"%>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>커뮤니티 게시판</title>
	</head>

	<body>
		<table>
			<tr>
				<th>글번호</th>
				<th>제목(수정됨)</th>
				<th>작성자</th>
				<th>게시날짜</th>
				<th>수정날짜</th>
			</tr>
			<tr>
				<% List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList");
						for (BoardVO vo : boardList) {
						%>
			</tr>
			<tr>
				<td>
						<%=vo.getIdx()%> 게시글 번호
					</td>
				<td>
					<%=vo.getTitle()%>
				</td>
				<td>
					<%=vo.getContent()%>
				</td>
				<td>
					<%=vo.getWriter()%>
				</td>
				<td>
					<%=vo.getDate()%>
				</td>
				<td>
					<%=vo.getNewdate()%>
				</td>
			</tr>
			<% } %>
		</table>
	</body>

	</html>