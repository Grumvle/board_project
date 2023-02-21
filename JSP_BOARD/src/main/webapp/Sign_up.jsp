<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<<<<<<< HEAD
=======

<html lang="en">
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
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
=======
<head>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script src="addr.js"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web Service Programming Homework</title>
	<link rel="stylesheet" href="resources/student.css" type="text/css">

</head>
<style>
    table {
        background: rgba(98, 95, 95, 0.515);
        height: 350px;
        width: 420px;
        border-radius: 15px;
    }

    .can {
        width: 150px;
        height: 25px;
        font-size: 14px;
    }

    #phone {
        width: 50px;
        height: 25px;
        font-size: 14px;
    }

    .address {
        width: 70px;
        height: 25px;
        font-size: 14px;
    }
</style>

<body>
	<header>Create Your Account</header>
    <form>
        <h2 align="center" font="bold">사용자 회원가입</h2>
        <table align="center">


            <tr>
                <th>이름 : </th>
                <td><input class="can" type="text" name="name"></td>
            </tr>
            <tr>
                <th>직업 : </th>
                <td><input type="radio" name="job" value="0" checked>무직
                    <input type="radio" name="job" value="1">학생
                    <input type="radio" name="job" value="2">직장인
                    <input type="radio" name="job" value="3">주부
                    <input type="radio" name="job" value="4">군인
                </td>
            </tr>
            <tr>
                <th>아이디 : </th>
                <td><input class="can" type="text" name="id"></td>
            </tr>
            <tr>
                <th>비밀번호 : </th>
                <td><input class="can" type="password" name="pwd"></td>
            </tr>
            <tr>
                <th>비밀번호 확인 : </th>
                <td><input class="can" type="password" name="pwd1"></td>
            </tr>
            <tr>
                <th>핸드폰 : </th>
                <td>
                    <select style="width:50px; height:33px;">
                        <option id="phone" value="010" >010</option>
                        <option id="phone" value="011" >011</option>
                        <option id="phone" value="017" >017</option>
                    </select>-
                    <input id="phone" type="tel" name="phone2" />-
                    <input id="phone" type="tel" name="phone3" />
                </td>
            </tr>
            <tr>
                <th>주소 : </th>
                <td>
                    <input class="address" width="50px" height="25px" type="text" id="postcode" placeholder="우편번호"
                        readonly>
                    <input class="can" type="button" id="postcode_button" onclick="open_Postcode()" value="우편번호 찾기"><br>
                    <input class="can" type="text" id="road_address" placeholder="도로 주소" readonly>
                    <input class="can" type="text" id="address" placeholder="지번 주소" readonly><br>
                </td>
            </tr>


        </table>
        <br>
        <div style=" text-align: center;">
            <input type="submit" vlaue="가입하기" aglign="center">
            <input type="reset" vlaue="다시작성" aglign="center">
        </div>

    </form>
</body>

>>>>>>> refs/remotes/origin/master
