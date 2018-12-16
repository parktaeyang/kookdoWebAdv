<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<% String ctx = request.getContextPath(); %>

<html>
<jsp:include page="../../commonHeader.jsp" />
<link rel="stylesheet" href="<c:url value="/resources/css/board/board.css" />" >
<body>
<section class="content">
<div class="probootstrap-main">
	<section class="probootstrap-section">
		<div class="section">
			<div class="container">
			
				<div align="center">
					<article class="container">
						<form name="joinForm" id="joinForm">
							<table id="table_info" class="table">
								<tr>
									<td colspan="6"></td>
								</tr>
								<tr>
									<td colspan="6">▶회원가입</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>이름</td>
									<td>
										<input type="text" class="form-control" id="userId" name="userId">
									</td>
									<td bgcolor='#E6E6E6'>비밀번호</td>
									<td>
										<input type="text" class="form-control" id="password" name="password">
									</td>
									<td bgcolor='#E6E6E6'>구  분</td>
									<td>
										<select name="type" class="form-control" id="type" name="type">
										    <option value="company">기업</option>
										    <option value="person">개인</option>
										    <option value="staff">임직원</option>
										</select>
									</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>회사명</td>
									<td>
										<input type="text" class="form-control" id="company" name="company">
									</td>
									<td bgcolor='#E6E6E6'>주소</td>
									<td colspan="3">
										<input type="text" class="form-control" id="address" name="address">
									</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>E-mail</td>
									<td>
										<input type="text" class="form-control" id="email" name="email">
									</td>
									<td bgcolor='#E6E6E6'>Mobile</td>
									<td>
										<input type="text" class="form-control" id="mobile" name="mobile">
									</td>
									<td bgcolor='#E6E6E6'>T E L</td>
									<td>
										<input type="text" class="form-control" id="tel" name="tel">
									</td>
								</tr>
								<tr>
									<td colspan="6"></td>
								</tr>
							</table>
		
							
							<div class="form-group text-center">
								<button type="button" class="btn btn-info"onclick="save()">
									저장 <i class="fa fa-check spaceLeft"></i>
								</button>
								<button type="button" class="btn btn-warning">
									취소 <i class="fa fa-times spaceLeft"></i>
								</button>
							</div>
						</form>
							
					</article>
				</div>
			</div>
		</div>
	</section>
</div>
</section>

</body>
<script src="<c:url value="/resources/js/user/join.js" />"></script>
<jsp:include page="../../commonFooter.jsp" />
</body>
</html>