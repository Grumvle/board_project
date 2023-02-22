package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/UpdateMemberServlet")
public class UpdateMemberServlet extends HttpServlet {
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
	public UpdateMemberServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

		request.setCharacterEncoding("UTF-8");
		member_name = request.getParameter("name");
		member_id = request.getParameter("id");
		member_pwd = request.getParameter("pwd");
		member_phone = request.getParameter("phone");
		member_addr = request.getParameter("addr");

		try {
			Class.forName(jdbc_driver);
			con = DriverManager.getConnection(jdbc_url, "jspbook", "1234");
			String sql = "update member sat member_name =?,member_pwd=?,member_phone=?,member_addr=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_name);
			pstmt.setString(2, member_pwd);
			pstmt.setString(3, member_phone);
			pstmt.setString(4, member_addr);

			int i = pstmt.executeUpdate();
			if (i == 1) {

				System.out.println("update success");
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("name", member_name);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
