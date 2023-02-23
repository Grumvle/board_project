package controller;

import java.io.IOException;
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
 * Servlet implementation class AdminServlet
 */

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 관리자 권한 계정용 서블릿.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String cmdReq = "";

		String message = "";

		cmdReq = request.getParameter("cmd");

		if (cmdReq.equals("Member_List(Admin)")) {

			MemberDAO dao = new MemberDAO();
			ArrayList<MemberVO> memberList = dao.getMemberList();
			request.setAttribute("memberList", memberList);
			RequestDispatcher view = request.getRequestDispatcher("User_Delete(Admin).jsp");
			view.forward(request, response);

		} else if (cmdReq.equals("delete")) {

			String id = request.getParameter("id");
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberVO> memberList = dao.delete(request.getParameter("id"));
			request.setAttribute("memberList", memberList);
			RequestDispatcher view = request.getRequestDispatcher("Delete_Member_Result(Admin).jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 관리자 권한 계정용 서블릿.
	// 관리자 권한 계정의 id를 admin으로 설정한뒤
	// request.getParameter의 값을 admin이냐 아니냐로 구분해서
	// 관리자 권한 페이지를 띄우면 되는 간단한 로직이다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String cmdReq = "";

		String message = "";

		if (cmdReq.equals("Member_List(Admin)")) {
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberVO> memberList = dao.getMemberList();
			request.setAttribute("memberList", memberList);
			RequestDispatcher view = request.getRequestDispatcher("User_Delete(Admin");
			view.forward(request, response);
		}

		doGet(request, response);
	}

}
