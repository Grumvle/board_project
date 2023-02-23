//package persistence;
//
//import java.sql.*;
//
//import javax.servlet.http.HttpSession;
//
//import model.MemberVO;
//
//public class Sign_inDAO {
//
//	private Connection conn = null;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs = null;
//	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
//	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
//
//	void connect() {
//		try {
//			Class.forName(jdbc_driver);
//			conn = DriverManager.getConnection(jdbc_url, "root", "1234");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	void disconnect() {
//		if (pstmt != null) {
//			try {
//				pstmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		if (conn != null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	// 로그인 하기 위한 메서드
//	public boolean sign_in(String sign_id, String sign_pwd) {
//
//		String member_name;
//
//		String member_id;
//
//		String member_pwd;
//
//		String member_phone;
//
//		String member_addr;
//
//		boolean sign_b = false;
//
//		try {
//			connect();
//			String sql = "select * from member where id='" + sign_id + "' and pw='" + sign_pwd + "'";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery(sql);
//
//			MemberVO vo = new MemberVO();
//			while (rs.next()) {
//				vo.setName(rs.getString("member_name"));
//				vo.setName(rs.getString("member_id"));
//				vo.setName(rs.getString("member_pwd"));
//				vo.setName(rs.getString("member_phone"));
//				vo.setName(rs.getString("member_addr"));
//
//				sign_b = true;
//			}
//			if (sign_b) {
//				System.out.println("[ 로그인 성공 ]");
//				HttpSession httpSession = request.getSession();
//				httpSession.setAttribute("name", orgin_name);
//				httpSession.setAttribute("id", orgin_id);
//				httpSession.setAttribute("pw", orgin_pw);
//				httpSession.setAttribute("phone", orgin_phone);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		} finally {
//			disconnect();
//		}
//		return true;
//	}
//
//}
