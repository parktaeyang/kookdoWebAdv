<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<% String ctx = request.getContextPath(); %>

<html>
<jsp:include page="../../commonHeader.jsp" />

<body>
	<div class="probootstrap-main">
		<section class="probootstrap-section">
			<div class="section">
				<div class="container">
					<div class="row">
						<div class="col-lg-6">
							<form class="form-signin" name="loginData" id="loginData">
								<img class="mb-4"
									src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg"
									alt="" width="72" height="72">
								<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
								<input type="text" id="userId" name="userId"
									class="form-control" placeholder="ID"> <input
									type="password" id="password" name="password"
									class="form-control" placeholder="Password">
								<div class="checkbox mb-3">
									<label> <input type="checkbox" value="remember-me">
										Remember me
									</label> <label> <a href="goJoin.do">Join</a>
									</label>
								</div>

								<button type="button" class="btn btn-lg btn-primary btn-block" onclick="login()">Login</button>
								<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>

<jsp:include page="../../commonFooter.jsp" />
<script src="<c:url value="/resources/js/user/login.js" />"></script>
</body>
</html>