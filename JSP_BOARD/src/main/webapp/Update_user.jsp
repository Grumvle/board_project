<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 이전화면에서 전달받은 데이터를 받습니다.
// 화면에 미리 보여지도록 처리를 하세요~
request.setCharacterEncoding("UTF-8");

String member_name = (String) request.getAttribute("member_name");
String member_id = (String) request.getAttribute("member_id");
String member_pwd = (String) request.getAttribute("member_pwd");
String member_phone = (String) request.getAttribute("member_phone");
String member_addr = (String) request.getAttribute("member_addr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>

	<h2>정보 수정페이지</h2>

	<form action="Update_Result.jsp" method="post">
	
		아이디:<input type="text" name="member_id" value="<%=member_id%>"><br/> 
		
		비밀번호:<input type="password" name="member_pwd"><br/> 
		
		이름:<input type="text" name="member_name" value="<%=member_name%>"><br/> 
		
		전화번호:<input type="text" name="member_phone" value="<%=member_phone%>"><br/> 
		
		주소:<input type="text" name="member_addr" value="<%=member_addr%>"><br/> 
		
		<input type="submit" value="수정">
	</form>

	<hr />

</body>
</html>