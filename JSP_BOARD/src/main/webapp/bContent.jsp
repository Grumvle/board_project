<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<!-- 댓글 입력처리 -->
	<form name="contForm" method="post"
		action="http://localhost:8787/JSP_BOARD/BoardServlet?cmd=/bContInput.bo">
		<table class="table">
			<tr>
				<td style="text-align: left; width: 90%;"><label for="content">글내용
						: </label> <textarea class="form-control" rows="5" id="content"
						name="content"></textarea></td>
				<td style="line-height: 20px;"><br />
				<br />
					<p>
						<input type="text" name="nickname" size="6" value="${snickname}"
							readonly />
					</p>
					<p>
						<input type="button" value="댓글달기" onclick="reCheck()" />
					</p>
					<p>
						<input type="button" value="돌아가기"
							onclick="location.href='${contextPath}/bList.bo?pag=${pag}';" />
					</p></td>
			</tr>
		</table>
		<input type="hidden" name="idx" value="${vo.idx}" /> <input
			type="hidden" name="hostip" value="<%=request.getRemoteAddr()%>" /> <input
			type="hidden" name="pag" value="${pag}" /> <input type="hidden"
			name="mid" value="${smid}" />
	</form>

</body>
</html>