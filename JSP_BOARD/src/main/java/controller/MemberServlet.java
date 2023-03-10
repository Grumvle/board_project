package controller;

import java.io.IOException;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		

//			 이해가 안되는 부분은 jsp에서 cmd로 메시지를 서블릿으로 보낼때 어떻게 id값을 getParameter로
//			 보내는지가 궁금하다. 그부분은 따로 공부를 해야겠다.
//			ArrayList<MemberVO> memberList = dao.delete(request.getParameter("id"));
//			request.setAttribute("memberList", memberList);
		
//		String cmdReq = "";
//		if (cmdReq.equals("OneUserList")) {
//			MemberDAO dao = new MemberDAO();
//			
//			ArrayList<MemberVO> memberList = dao.getOneMemberList("Sds");
//			request.setAttribute("memberList", memberList);
//			RequestDispatcher view = request.getRequestDispatcher("");
//			view.forward(request, response);
//		}
//
	
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
		String message = "";

		cmdReq = request.getParameter("cmd");
		if (cmdReq.equals("join")) {

			MemberVO memberVO = new MemberVO();

			memberVO.setName(request.getParameter("name"));
			memberVO.setId(request.getParameter("id"));
			memberVO.setPwd(request.getParameter("pwd"));
			memberVO.setPhone(request.getParameter("phone"));
			memberVO.setAddr(request.getParameter("addr"));
			/*
			 * memberVO.setAddr("(" + request.getParameter("addr") + ") " +
			 * request.getParameter("addr1") + " " + request.getParameter("addr2"));
			 */

			/* memberVO.setAddr(request.getParameter("addr")); */

//			MemberDAO memberDAO = new MemberDAO();
			MemberDAO dao = MemberDAO.getInstance();
			dao.add(memberVO);

			request.setAttribute("member", memberVO);

			RequestDispatcher view = request.getRequestDispatcher("Result.jsp");
			view.forward(request, response);

		}
		// 관리자 권한이 아닌 개인 회원의 권한으로 개인 회원의 정보를 삭제하기 위한 메서드.

		else if (cmdReq.equals("delete")) {
			MemberVO memberVO = new MemberVO();
			memberVO.setId(request.getParameter("id"));
			MemberDAO dao = MemberDAO.getInstance();

			if (dao.delete(memberVO)) {
				message = "회원님의 탈퇴가 완료되었습니다.";
				RequestDispatcher view = request.getRequestDispatcher("Delete_Complete.jsp");
				view.forward(request, response);
			} else {
				message = "회원님의 탈퇴가 완료되지 않았습니다.";
			}

//			 이해가 안되는 부분은 jsp에서 cmd로 메시지를 서블릿으로 보낼때 어떻게 id값을 getParameter로
//			 보내는지가 궁금하다. 그부분은 따로 공부를 해야겠다.
//			ArrayList<MemberVO> memberList = dao.delete(request.getParameter("id"));
//			request.setAttribute("memberList", memberList);
		} else if (cmdReq.equals("update")) {

			// 멤버에 집어넣기 위한 MemberVO에 대한 참조변수를 생성
			MemberVO memberVO = new MemberVO();
			memberVO.setId(request.getParameter("userid"));
			memberVO.setName(request.getParameter("username"));
			memberVO.setPwd(request.getParameter("userpasswd"));
			memberVO.setPhone(request.getParameter("userphone"));
			memberVO.setAddr(request.getParameter("useraddr"));
			/*
			 * memberVO.setAddr("(" + request.getParameter("addr") + ")=" +
			 * request.getParameter("addr1") + "=" + request.getParameter("addr2"));
			 */
//
			MemberDAO dao = MemberDAO.getInstance();
			if (dao.update(memberVO)) {
				message = "수정이 완료되었습니다.";
			} else {
				message = "수정을 실패하였습니다.";
			}

			request.setAttribute("message", message);
			request.setAttribute("member", memberVO);

			RequestDispatcher view = request.getRequestDispatcher("User_Update_Result.jsp");
			view.forward(request, response);
		}
	}

}
