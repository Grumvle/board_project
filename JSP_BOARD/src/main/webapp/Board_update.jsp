<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
import="model.BoardVO, persistence.BoardDAO, java.util.List"%>
<%BoardVO boardView = (BoardVO) request.getAttribute("boardPost");
		System.out.println(boardView.getTitle());%>
<%! String idx; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 화면</title>

<!-- JQury 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css"
	integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js"
	integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
	crossorigin="anonymous"></script>

<!-- include summernote css/js -->
<!-- summernote 스타일 관련 cdn -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.6/summernote.css">
<!-- summernote 자바스크립트 관련 cdn -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.6/summernote.js"></script>
<!-- summernote 한글 처리 관련 cnd -->
<script
	type="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.6/lang/summernote-ko-KR.js"></script>
<!--  -->
<script>
	$(function() {
		$("#myEditor").summernote({
			lang : 'ko- KR',
			height : 300
		});
	});
</script>


</head>
<body>
	<!--  -->
	<div class="container">
		<form action="http://localhost:8787/JSP_BOARD/BoardServlet?cmd=one" method="post">
			<br>
			<br>
			<fieldset>
				<legend>게시물 수정</legend>
				<ul>
					<li>게시글 번호 : <input type="hidden" name="idx"
						value="<%=idx = boardView.getIdx()%>"></li>
					<li>작성자 : <input type="text" name="writer" required
						value="<%=boardView.getWriter()%>">
					</li>

					<li>제목 : <input type="text" name="title" required
						value=<%=boardView.getTitle()%>></li>

					<li>비밀번호 : <input type="checkbox" name="pwd_chk"
						value="pwd_chk">
						<input type="password" name="pwd" placeholder="선택입력" value ="<%=boardView.getPwd()%>"></li>
					<li>내용 : <input type ="text" name ="content" value="<%=boardView.getContent()%>"></li>

				</ul>
					
				<textarea id="myEditor" rows="10" cols="30" class="form-control"><%=boardView.getContent()%></textarea>

				<br> 
				<input type="submit" value="수정">
				<a href="http://localhost:8787/JSP_BOARD/BoardServlet?cmd=one">수정</a> 
				<input type="reset" name="reset" value="다시 작성">

			</fieldset>
		</form>
	</div>
</body>
</html>