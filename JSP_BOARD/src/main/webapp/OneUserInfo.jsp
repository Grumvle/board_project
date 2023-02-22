<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 정보수정 화면으로 가기전에
// 아이디 기준으로 회원정보를 조회해서 다음 화면으로 전달

String member_id = (String) session.getAttribute("member_id");
//DB연결에 필요한 변수 선언
String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
String jdbc_driver = "com.mysql.cj.jdbc.Driver";
String user = "jspbook";
String pwd = "1234";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String sql = "select * from member where member_id = ?";

try {
	// 드라이버 호출
	Class.forName(jdbc_driver);

	// conn 생성
	conn = DriverManager.getConnection(jdbc_url, user, pwd);

	// pstmt 생성
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, member_id);

	// sql실행
	rs = pstmt.executeQuery();

	if (rs.next()) {
		member_id = rs.getString("member_id");
		String member_name = rs.getString("member_name");
		String member_pwd = rs.getString("member_pwd");
		String member_phone = rs.getString("member_phone");
		String member_addr = rs.getString("member_addr");

		// 포워드로 전달하기 위해
		request.setAttribute("member_id", member_id);
		request.setAttribute("member_name", member_name);
		request.setAttribute("member_pwd", member_pwd);
		request.setAttribute("member_phone", member_phone);
		request.setAttribute("member_addr", member_addr);

		// 포워드 이동
		request.getRequestDispatcher("Update_user.jsp").forward(request, response);

	} else { // 세션이 만료된 경우
		response.sendRedirect("Sign_in.jsp");
	}
} catch (Exception e) {
	e.printStackTrace();
	response.sendRedirect("Sign_in.jsp");
} finally {
	try {
		if (conn != null)
	conn.close();
		if (pstmt != null)
	pstmt.close();
		if (rs != null)
	rs.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
%>