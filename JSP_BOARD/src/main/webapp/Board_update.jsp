<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.BoardVO, persistence.BoardDAO, java.util.List"%>
<%
BoardVO boardView = (BoardVO) request.getAttribute("boardPost");
System.out.println(boardView.getTitle());
%>
<%!String idx;%>
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

<style>
	#pwd{
		width:150px;
		float:right;
		position: relative;
		bottom: 9px;
	}
	.container{
		margin-top: 20px;
	}
	label{
		margin-bottom:10px;
	}
	
</style>

</head>
<body>
	
		<div class="container">
		
			<form action="http://localhost:8787/JSP_BOARD/BoardServlet?cmd=one"
				method="post">
				
				<div class="form-group">
					<input type="hidden" name="idx"
						value="<%=idx = boardView.getIdx()%>"> 
						<input type="hidden" name="writer"
						value="<%=boardView.getWriter()%>">
						<label for="title">제목:</label>
					<input type="text" class="form-control" id="title" name="title" value="<%=boardView.getWriter()%>">
												
				</div>
				<div class="form-group">
					<label for="content">내용: </label> 
					<input type="text" class="form-control" id="pwd" name="pwd" value="<%=boardView.getPwd()%>"><label for="pwd" style="float:right;">비밀번호 : &nbsp</label> 
					
					<textarea class="form-control" rows="5	" id="summernote"
						name="content"><%=boardView.getContent()%></textarea>
				</div>
				<button type="submit" class="btn btn-primary">글쓰기 수정</button>
				<button type="reset" class="btn btn-danger">다시 작성</button>
			</form>
		</div>
		
	<script>
			$(document).ready(function() {
				$('#summernote').summernote({
					tabsize : 2,
					height : 500
				});
			});
			
		</script>
</body>
</html>