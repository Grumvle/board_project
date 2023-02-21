<%@page import="model.ModelBean"%>
<%@page import="model.ModelDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String userName = request.getParameter("name");
	String userJob = request.getParameter("job");
	String userId = request.getParameter("id");
	String userPwd = request.getParameter("pwd");
	String userPhone = request.getParameter("phone");
	String userAddr = request.getParameter("address");
	
	ModelBean bean = new ModelBean();
	bean.setName(userName);
	bean.setJob(userJob);
	bean.setId(userId);
	bean.setPwd(userPwd);
	bean.setPhone(userPhone);
	bean.setAddr(userAddr);
	
	
	ModelDAO dao = new ModelDAO();

	dao.MemberInsert(bean);
	

%>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
		</head>

		<body>
			<h2>모든 회원보기</h2>
			<table border="1">
				<tr height="50">
					<td width="150" align="center">이름</td>
					<td width="200" align="center">직업</td>
					<td width="150" align="center">아이디</td>
					<td width="200" align="center">비밀번호</td>
					<td width="100" align="center">핸드폰</td>
					<td width="100" align="center">주소</td>
				</tr>
				<c:forEach var="bean" items="${list }">
					<tr height="50">
						<td width="150" align="center">${bean.id}</td>
						<td width="200" align="center">${bean.email}</td>
						<td width="150" align="center">${bean.tel}</td>
						<td width="200" align="center">${bean.hobby}</td>
						<td width="100" align="center">${bean.job}</td>
						<td width="100" align="center">${bean.age}</td>
					</tr>
				</c:forEach>

			</table>
		</body>

		</html>