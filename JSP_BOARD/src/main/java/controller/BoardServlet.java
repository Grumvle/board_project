package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		String cmdReq = request.getParameter("cmd");

		if (cmdReq.equals("view")) {
			BoardDAO dao = new BoardDAO();
			String idx = request.getParameter("idx");
			BoardVO boardPost = dao.getBoardPostOne(idx);
			request.setAttribute("boardPost", boardPost);

			RequestDispatcher view = request.getRequestDispatcher("Board_view.jsp");
			view.forward(request, response);

		} else if (cmdReq.equals("read")) {
			BoardDAO dao = new BoardDAO();

			ArrayList<BoardVO> boardList = dao.getBoardList();
			request.setAttribute("boardList", boardList);
			RequestDispatcher view = request.getRequestDispatcher("Board_list.jsp");
			view.forward(request, response);

		} else if (cmdReq.equals("updateRead")) {
			System.out.println("1111");
			BoardDAO dao = new BoardDAO();
			String idx = request.getParameter("idx");
			BoardVO boardPost = dao.getBoardPostOne(idx);
			request.setAttribute("boardPost", boardPost);

			RequestDispatcher view = request.getRequestDispatcher("Board_update.jsp");
			view.forward(request, response);

		}
//
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

			boardVO.setTitle(request.getParameter("title"));
			boardVO.setContent(request.getParameter("content"));
			boardVO.setPwd(request.getParameter("pwd"));

			BoardDAO boardDAO = new BoardDAO();

			boardDAO.add(boardVO, loginId);

			request.setAttribute("board", boardVO);

			RequestDispatcher view = request.getRequestDispatcher("Board_result.jsp");
			view.forward(request, response);

		} else if (cmdReq.equals("update")) {
			BoardDAO dao = new BoardDAO();
			System.out.println("Servlet 시작");

			BoardVO vo = new BoardVO();

			// System.out.println(request.getParameter("content"));

			vo.setIdx(request.getParameter("idx"));
			vo.setWriter(request.getParameter("writer"));
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));

			String pwd = request.getParameter("pwd");
			if (pwd.equals(null) || pwd.equals("")) {
				vo.setPwd(" ");
			} else {
				vo.setPwd(request.getParameter("pwd"));
			}
			System.out.println("DAO 시작전");

			dao.update(vo);
			request.setAttribute("boardPost", vo);

			System.out.println("Servlet 끝");
			RequestDispatcher view = request.getRequestDispatcher("Board_view.jsp");
			view.forward(request, response);
		} 
			//else if (cmdReq.equals("delete")) {
//			BoardDAO dao = new BoardDAO();
//
//			String idx = request.getParameter("idx");
//
//			dao.delete(idx);
//
//			PrintWriter writer = response.getWriter();
//			writer.println("<script>alert('게시물 삭제가 완료되었습니다.'); location.href='Board_list.jsp';</script>");
//			writer.close();
//			response.sendRedirect("pagePath");
//		}
	}
}
