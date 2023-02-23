package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardVO;
import persistence.BoardDAO;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("id");

		String cmdReq = "";

		cmdReq = request.getParameter("cmd");
		if (cmdReq.equals("join")) {
			BoardVO boardVO = new BoardVO();

			boardVO.setWriter(request.getParameter("writer"));
			boardVO.setTitle(request.getParameter("title"));
			boardVO.setContent(request.getParameter("content"));
			boardVO.setPwd(request.getParameter("pwd"));

			BoardDAO boardDAO = new BoardDAO();

			boardDAO.add(boardVO,loginId);

			request.setAttribute("board", boardVO);
			
			RequestDispatcher view = request.getRequestDispatcher("Board_result.jsp");
			view.forward(request, response);
			
		}else if(cmdReq.equals("update")) {
			BoardVO boardVO = new BoardVO();

			boardVO.setWriter(request.getParameter("writer"));
			boardVO.setTitle(request.getParameter("title"));
			boardVO.setContent(request.getParameter("content"));
			boardVO.setPwd(request.getParameter("pwd"));

			BoardDAO boardDAO = new BoardDAO();

			boardDAO.add(boardVO,loginId);

			request.setAttribute("board", boardVO);
			
			RequestDispatcher view = request.getRequestDispatcher("Board_UpdateResult.jsp");
			view.forward(request, response);
		}
	}
}
