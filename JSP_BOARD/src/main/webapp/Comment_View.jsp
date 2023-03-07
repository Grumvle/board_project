<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comment</title>
</head>
<body>

	<form
		action="http://localhost:8787/JSP_BOARD/?cmd=join"
		method="post">
		<fieldset>
			<legend>Comment_Register</legend>
			<ul>
				<li>아이디 : <input type="text" name="comment_id" autofocus required
					placeholder="아이디를 입력하세요."></li>
				<li>비밀번호 : <input type="text" name="comment_passwd" required
					placeholder="비밀번호를 입력하세요."></li>
				<li>내용을 입력하세요... : <input type="text" name="comment_content" required
					placeholder="공백없이 입력하세요"></li>
			</ul>
		</fieldset>
		<br>
		<fieldset>
			<input type="submit" name="submit" value="등록"> <input
				type="reset" name="reset" value="등록 + 추천">
		</fieldset>
	</form>

</body>
</html>