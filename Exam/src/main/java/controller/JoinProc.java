package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelBean;
import model.ModelDAO;

@WebServlet("/JoinProc")
public class JoinProc extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);
	}	
	protected void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		ModelBean bean = new ModelBean();
		ModelDAO mdao = new ModelDAO();
		//폼에 입력한 정보를 갖고옴.

		bean.setName(request.getParameter("name"));
		bean.setName(request.getParameter("job"));
		bean.setName(request.getParameter("id"));
  		//패스워드, 패스워드확인을 비교하기 위해 변수에 저장.
		String pass1 = request.getParameter("pwd");
		String pass2 = request.getParameter("pwd1");
		bean.setPwd(pass1);
		bean.setPhone(request.getParameter("phone"));
		bean.setAddr(request.getParameter("addr"));
		bean.setInfo(request.getParameter("info"));
		
		if(pass1.equals(pass2)) { //패스워드, 패스워드 확인이 일치할 경우
			mdao.MemberInsert(bean);
			//컨트롤러에서 또다른 컨트롤러를 호출
			RequestDispatcher rdis = request.getRequestDispatcher("MemberListLoc");
			rdis.forward(request, response);
		}else {
			RequestDispatcher rdis = request.getRequestDispatcher("LoginError.jsp");
			rdis.forward(request, response);
	
		}
	}
}