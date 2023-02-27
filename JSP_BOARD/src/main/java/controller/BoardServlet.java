package controller;

import java.io.IOException;
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
			System.out.println("1234");
			BoardDAO dao = new BoardDAO();
			int idx = Integer.parseInt(request.getParameter("idx"));
			BoardVO boardPost = dao.getBoardPostOne(idx);
			request.setAttribute("boardPost", boardPost);
			/*
			boardPost.setIdx(Integer.parseInt(request.getParameter("idx")));
			boardPost.setWriter(request.getParameter("writer"));
			boardPost.setTitle(request.getParameter("title"));
			boardPost.setContent(request.getParameter("content"));
			boardPost.setViewcnt(Integer.parseInt(request.getParameter("viewcnt")));
			boardPost.setLikecnt(Integer.parseInt(request.getParameter("likecnt")));
			boardPost.setPwd(request.getParameter("pwd"));
			boardPost.setDate(request.getParameter("date"));
			boardPost.setNewdate(request.getParameter("newdate"));
			*/
			
			RequestDispatcher view = request.getRequestDispatcher("Board_view.jsp");
			view.forward(request, response);

		}else if (cmdReq.equals("read")) {
			BoardDAO dao = new BoardDAO();

			ArrayList<BoardVO> boardList = dao.getBoardList();
			request.setAttribute("boardList", boardList);
			RequestDispatcher view = request.getRequestDispatcher("Board_list.jsp");
			view.forward(request, response);

		}
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
			int idx = (int)request.getAttribute("idx");
			BoardVO boardVO = dao.getBoardPostOne(idx);

			String id = request.getParameter("writer");

			boardVO.setWriter(request.getParameter("writer"));
			boardVO.setTitle(request.getParameter("title"));
			boardVO.setContent(request.getParameter("content"));
			boardVO.setPwd(request.getParameter("pwd"));

			BoardDAO boardDAO = new BoardDAO();

			boardDAO.add(boardVO, loginId);

			request.setAttribute("board", boardVO);

			RequestDispatcher view = request.getRequestDispatcher("Board_UpdateResult.jsp");
			view.forward(request, response);
		}
	}
}
