<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
1. 폼에서 넘어온 데이터를 각각 처리합니다.
2. SQL문을 이용해서 DB에 업데이트 작업.
3. executeUpdate() 성공시 1을 반환, 실패시 0을 반환
4. 업데이트가 성공하면 세션에 저장된 이름을 변경한 후에
	update_success.jsp로 리다이렉트
	
      업데이트에 실패하면, update_fail.jsp로 리다이렉트
*/
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("member_id");
String pw = request.getParameter("member_pwd");
String name = request.getParameter("member_name");
String phone = request.getParameter("member_phone");
String addr = request.getParameter("member_addr");

//DB연결에 필요한 변수 선언
String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
String jdbc_driver = "com.mysql.cj.jdbc.Driver";
String user = "jspbook";
String pwd = "1234";

Connection conn = null;
PreparedStatement pstmt = null;

String sql = "update member set member_pwd = ?, member_name = ?, member_phone = ?, member_addr = ?"
		+ "where member_id = ?";

try {
	// 드라이버 호출
	Class.forName("oracle.jdbc.driver.OracleDriver");

	// conn 생성
	conn = DriverManager.getConnection(jdbc_url, user, pwd);

	// pstmt 생성
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, pw);
	pstmt.setString(2, name);
	pstmt.setString(3, phone);
	pstmt.setString(4, addr);
	pstmt.setString(5, id);

	int result = pstmt.executeUpdate();

	if (result == 1) {
		session.setAttribute("user_name", name);

		response.sendRedirect("Sign_in.jsp");
	} else {
		response.sendRedirect("Main.jsp");
	}
} catch (Exception e) {
	e.printStackTrace();
	response.sendRedirect("Main.jsp");
} finally {
	try {
		if (conn != null)
	conn.close();
		if (pstmt != null)
	pstmt.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
%>