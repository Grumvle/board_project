<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 화면</title>
</head>
<body>
	<header>게시글을 작성하세요</header>
	<!--  -->
	<div>
		<form action="http://localhost:8787/JSP_BOARD/BoardServlet?cmd=join" method="post">
			<fieldset>
				<legend>Personnel Information</legend>
				<ul>
					<li>작성자 : <%= session.getAttribute("id") %> </li>

					<li>제목 : <input type="text" name="title" required
						placeholder="공백없이 입력하세요"></li>

					<li>비밀번호 : <input type="checkbox" name="pwd_chk" value="pwd_chk"><input type="password" name="pwd"
						placeholder="선택입력"></li>

					<li>내용 : <input type="text" name="content" required
						placeholder="공백없이 입력하세요"></li>

					
				</ul>

			</fieldset>
			
			<br>

			<fieldset>

				<input type="submit" name="submit" value="보내기"> <input
					type="reset" name="reset" value="다시 작성">

			</fieldset>
			
		</form>
	</div>
</body>
</html>