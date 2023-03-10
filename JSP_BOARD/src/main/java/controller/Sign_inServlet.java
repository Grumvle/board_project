package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Sign_inServlet
 */
@WebServlet("/Sign_inServlet")
public class Sign_inServlet extends HttpServlet {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String member_name;
	String member_id;
	String member_pwd;
	String member_phone;
	String member_addr;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sign_inServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// post getParameter
		String post_id = request.getParameter("id");
		String post_pw = request.getParameter("pw");

		// dao 부분 세션을 쓰기위해서는 dao를 이곳에 구현할 수 밖에 없다.
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

		boolean sign_b = false;

		try {
			Class.forName(jdbc_driver);
			con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
			String sql = "select * from member where member_id='" + post_id + "' and member_pwd='" + post_pw + "'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				member_name = rs.getString("member_name");
				member_id = rs.getString("member_id");
				member_pwd = rs.getString("member_pwd");
				member_phone = rs.getString("member_phone");
				member_addr = rs.getString("member_addr");
				sign_b = true;
			}

			/* String[] member_addrCut = member_addr.split("="); */

			// post_id를 'admin' 즉 관리자 권한으로 계정을 받았을 때 관리자 전용 세션을
			// 생성하고 관리자 전용 로그인결과 성공 화면. 그리고 나서 관리자 전용 페이지로 넘어가게 한다.
			if (post_id.equals("admin")) {
				System.out.println("[[ 관리자 권한으로 로그인 성공 ]]");

				HttpSession httpSession = request.getSession(true);

				httpSession.setAttribute("name", member_name);

				httpSession.setAttribute("id", member_id);

				httpSession.setAttribute("pw", member_pwd);

				httpSession.setAttribute("phone", member_phone);

				httpSession.setAttribute("addr", member_addr);

				/*
				 * httpSession.setAttribute("addr", member_addrCut[0]);
				 * httpSession.setAttribute("addr1", member_addrCut[1]);
				 * httpSession.setAttribute("addr2", member_addrCut[2]);
				 */

				RequestDispatcher view = request.getRequestDispatcher("Admin_Sign_Result.jsp");
				view.forward(request, response);
//
			} else if (sign_b) {
				System.out.println("[ 회원님 로그인 성공 ]");

				HttpSession httpSession = request.getSession(true);

				httpSession.setAttribute("name", member_name);

				httpSession.setAttribute("id", member_id);

				httpSession.setAttribute("pw", member_pwd);

				httpSession.setAttribute("phone", member_phone);

				httpSession.setAttribute("addr", member_addr);

				/*
				 * httpSession.setAttribute("addr", member_addrCut[0]);
				 * httpSession.setAttribute("addr1", member_addrCut[1]);
				 * httpSession.setAttribute("addr2", member_addrCut[2]);
				 */

				response.sendRedirect("Sign_Result.jsp");
//
			} else {
				System.out.println("아이디 또는 비밀번호가 다릅니다.");
				response.sendRedirect("Sign_In_failed.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	}
}
