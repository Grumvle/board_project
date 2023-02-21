<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Web Service Programming Homework</title>
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
</head>

<body>
	<header>Create Your Account</header>
	<p id=sect>
		반갑습니다.<br> 웹 서비스 프로그래밍 학생들을 위한 커뮤니티입니다. <br>
	</p>
	<div>
		<form
			action="http://localhost:8080/kyuhan_mvcdb/StudentServlet?cmd=join"
			method="post">
			<fieldset>
				<legend>Personnel Information</legend>
				<ul>
					<li>ID : <input type="text" name="id" autofocus required
						placeholder="공백없이 입력하세요"></li>
					<li>PASSWORD : <input type="text" name="passwd" required
						placeholder="공백없이 입력하세요"></li>
					<li>USERNAME : <input type="text" name="username" required
						placeholder="공백없이 입력하세요"></li>
					<li>STUDENTNUMBER : <input type="text" name="snum" required
						placeholder="공백없이 입력하세요"></li>
					<li>DEPARTMENT : <input type="text" name="depart"
						placeholder="공백없이 입력하세요"></li>
					<li>MOBILE : <input type="text" name="mobile"
						placeholder="***.****.****"></li>
					<li>EMAIL : <input type="text" name="email"
						placeholder="****@****.***"></li>
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