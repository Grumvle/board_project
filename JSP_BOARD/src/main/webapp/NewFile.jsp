<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>JSP_BOARD_SIGN_UP</title>
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
</head>
<!--  -->
<body>
	<header>Create Your Account</header>
	<p id=sect>
		반갑습니다.<br> 웹 서비스 프로그래밍 학생들을 위한 커뮤니티입니다. <br>
	</p>
	<div>
		<form action="http://localhost:8787/JSP_BOARD/MemberServlet?cmd=join"
			method="post">
			<fieldset>
				<legend>Personnel Information</legend>
				<ul>
					<li>ID : <input type="text" name="id" autofocus required
						placeholder="공백없이 입력하세요"></li>
					<li>이름 : <input type="text" name="name" required
						placeholder="공백없이 입력하세요"></li>
					<li>비밀번호 : <input type="text" name="pwd" required
						placeholder="공백없이 입력하세요"></li>
					<li>전화번호 : <input type="text" name="phone" required
						placeholder="공백없이 입력하세요"></li>
					<li>주소 : <input type="text" name="addr"
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