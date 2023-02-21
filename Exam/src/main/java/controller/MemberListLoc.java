package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelBean;
import model.ModelDAO;

@WebServlet("/MemberListLoc")
public class MemberListLoc extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);
	}	
	protected void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//여기서 리스트에 띄어줄 DAO 호출
		ModelDAO mdao = new ModelDAO();
		//MemberList.jsp로 보낼 list를 셋팅해줌.
		ArrayList<ModelBean> list = mdao.getAllList();
		request.setAttribute("list", list);
		RequestDispatcher rdis= request.getRequestDispatcher("MemberList.jsp");
		rdis.forward(request, response);
	}
}