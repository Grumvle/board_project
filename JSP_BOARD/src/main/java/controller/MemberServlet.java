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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
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
			memberVO.setAddr("("+request.getParameter("addr")+") "+request.getParameter("addr1")+" "+request.getParameter("addr2"));
			
			MemberDAO memberDAO = new MemberDAO();
			
			memberDAO.add(memberVO);
			
			request.setAttribute("member", memberVO);
			
			RequestDispatcher view = request.getRequestDispatcher("Result.jsp");
			view.forward(request, response);
		}
	}

}

/*
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { 
 * // TODO Auto-generated
 * method stub request.setCharacterEncoding("UTF-8");
 * response.setContentType("text/html; charset=UTF-8");
 * 
 * String cmdReq = ""; String message = "";
 * 
 * cmdReq = request.getParameter("cmd"); 
 * if (cmdReq.equals("join")) { 
 * 
 * StudentVO studentVO = new StudentVO();
 * 
 * // 회원가입시 필요한 정보들이 StudentVO에 저장이 되어짐.
 * studentVO.setId(request.getParameter("id"));
 * studentVO.setPasswd(request.getParameter("passwd"));
 * studentVO.setUsername(request.getParameter("username"));
 * studentVO.setSnum(request.getParameter("snum"));
 * studentVO.setDepart(request.getParameter("depart"));
 * studentVO.setMobile(request.getParameter("mobile"));
 * studentVO.setEmail(request.getParameter("email"));
 * 
 * StudentDAO studentDao = new StudentDAO();
 * 
 * if (studentDao.add(studentVO)) message = "가입 축하합니다"; 
 * 
 * else message = "가입 실패입니다";
 * 
 * request.setAttribute("greetings", message); 
 * request.setAttribute("student", studentVO);
 * 
 * RequestDispatcher view = request.getRequestDispatcher("/result.jsp");
 * view.forward(request, response);
 * 
 * } 
 * }
 */