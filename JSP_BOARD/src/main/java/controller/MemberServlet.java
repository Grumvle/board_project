package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberVO;
import persistence.MemberDAO;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String cmdReq = "";
	
//		 로그인 했을시 회원이 개인정보를 수정할수 있게 하는 메서드.
//		 관리자 권한이 아니다.
		if (cmdReq.equals("modify")) {
			MemberDAO dao = new MemberDAO();
			
			ArrayList<MemberVO> memberList = dao.getMemberList();
			request.setAttribute("memberList", memberList);
			RequestDispatcher view = request.getRequestDispatcher("Update_user.jsp");
			view.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String cmdReq = "";
//		String message = "";

		cmdReq = request.getParameter("cmd");
		if (cmdReq.equals("join")) {

			MemberVO memberVO = new MemberVO();

			memberVO.setName(request.getParameter("name"));
			memberVO.setId(request.getParameter("id"));
			memberVO.setPwd(request.getParameter("pwd"));
			memberVO.setPhone(request.getParameter("phone"));
			memberVO.setAddr(request.getParameter("addr"));

			MemberDAO memberDAO = new MemberDAO();

			memberDAO.add(memberVO);

			request.setAttribute("member", memberVO);

			RequestDispatcher view = request.getRequestDispatcher("Result.jsp");
			view.forward(request, response);
		}
	}

}
