<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Web Service Programming Homework</title>
<<<<<<< HEAD
<link rel="stylesheet" type="text/css"></link>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="addr.js"></script>
<script src="Password_chk.js"></script>

=======
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
>>>>>>> refs/remotes/origin/master
</head>

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
					<li>이름 : <input type="text" name="name" autofocus required
						placeholder="공백없이 입력하세요"></li>
					<li>아이디 : <input type="text" name="id" required
						placeholder="공백없이 입력하세요"></li>
					<li>비밀번호 : <input type="text" name="pwd" required
						placeholder="공백없이 입력하세요"></li>
					<li>전화번호 : <input type="text" name="phone" required
						placeholder="공백없이 입력하세요"></li>
					<li>주소 : <input type="text" name="addr"
						placeholder="공백없이 입력하세요"></li>

<<<<<<< HEAD
					<li>아이디 : <input type="text" name="id" required placeholder="공백없이 입력하세요"></li>

					<li>비밀번호 : <input type="password" name="pwd" id="pwd" onchange="check_pw()" required placeholder="공백없이 입력하세요"></li>
					
					<li>비밀번호 확인: <input type="password" name="pwd_again" id="pwd_again" onchange="check_pw()" required placeholder="공백없이 입력하세요"><span id="check"></span></li>

					<li>전화번호 : <input type="text" name="phone" required placeholder="공백없이 입력하세요"></li>

					<li>
						주소 : 
						<input name="addr" type="text" id="postcode" placeholder="우편번호" readonly>
                    	<input type="button" id="postcode_button" onclick="open_Postcode()" value="우편번호 찾기"><br>
                    	<input name="addr1" type="text" id="road_address" placeholder="도로 주소" readonly><br>
                    	<input name="addr2" type="text" id="extra_address" placeholder="상세 주소"><br>
					</li>
					
=======
>>>>>>> refs/remotes/origin/master
				</ul>
			</fieldset>
			<br>
			<fieldset>
<<<<<<< HEAD

				<input type="button" name="submit" onclick="submit();" value="보내기"> <input
=======
				<input type="submit" name="submit" value="보내기"> <input
>>>>>>> refs/remotes/origin/master
					type="reset" name="reset" value="다시 작성">
			</fieldset>
		</form>
	</div>

</body>
</html>