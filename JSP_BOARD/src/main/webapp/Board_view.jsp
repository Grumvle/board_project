<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.BoardVO, persistence.BoardDAO, java.util.List"%>

<%@ page import="java.io.PrintWriter"%>
<%@ page import="model.BoardVO"%>

<%@ page import="model.CommentVO"%>
<%@ page import="persistence.CommentDAO"%>데이터베이스 접근 객체 가져오기
<%@ page import="java.util.ArrayList"%>
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
	<button
		onclick="location.href='http://localhost:8787/JSP_BOARD/BoardServlet?cmd=read';">목록</button>
	<button
		onclick="location.href='http://localhost:8787/JSP_BOARD/BoardServlet?cmd=updateRead&idx=<%=idx = boardView.getIdx()%>';">수정</button>
	<button
		onclick="location.href='http://localhost:8787/JSP_BOARD/BoardServlet?cmd=delete';">삭제</button>

	<br>
	<br>
	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<tbody>
					<tr>
						<td align="left" bgcolor="skyblue">댓글</td>
					</tr>
					<tr>
						<%
						CommentDAO commentDAO = new CommentDAO();
						ArrayList<CommentVO> list = commentDAO.getList(board_idx);
						for (int i = 0; i < list.size(); i++) {
						%>
						<div class="container">
							<div class="row">
								<table class="table table-striped"
									style="text-align: center; border: 1px solid #dddddd">
									<tbody>
										<tr>
											<td align="left"><%=list.get(i).getUserID()%></td>

											<td align="right"><%=list.get(i).getCommentDate().substring(0, 11) + list.get(i).getCommentDate().substring(11, 13) + "시"
		+ list.get(i).getCommentDate().substring(14, 16) + "분"%></td>
										</tr>

										<tr>
											<td align="left"><%=list.get(i).getCommentContent()%></td>
											<td align="right"><a
												href="commentUpdate.jsp?bbsID=<%=bbsID%>&commentID=<%=list.get(i).getCommentID()%>"
												class="btn btn-warning">수정</a> <a
												onclick="return confirm('정말로 삭제하시겠습니까?')"
												href="commentDeleteAction.jsp?bbsID=<%=bbsID%>&commentID=<%=list.get(i).getCommentID()%>"
												class="btn btn-danger">삭제</a></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<%
						}
						%>
					</tr>
			</table>
		</div>
	</div>
	<br>
	<div class="container">
		<div class="row">
			<form method="post" action="submitAction.jsp?bbsID=<%=bbsID%>">
				<table class="table table-bordered"
					style="text-align: center; border: 1px solid #dddddd">
					<tbody>
						<tr>
							<td align="left"><%=userID%></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="댓글 쓰기" name="commentContent" maxlength="300"></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-success pull-right"
					value="댓글 쓰기">
			</form>
		</div>
	</div>
	</div>
	</div>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>

</html> --%>