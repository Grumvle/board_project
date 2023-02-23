<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log_in</title>
</head>
<!-- 로그인 구현 : POST -->

<body>
	<h1>아이디와 비밀번호를 확인해 주십시오.</h1>
	<form
		action="http://localhost:8787/JSP_BOARD/Sign_inServlet?cmd=sign_in"
		method="post">
		아이디:<input type="text" name="id"><br /> 비밀번호:<input
			type="password" name="pw"><br /> <input type="submit"
			value="로그인"><br />
	</form>

</body>

<!--  -->
</html>