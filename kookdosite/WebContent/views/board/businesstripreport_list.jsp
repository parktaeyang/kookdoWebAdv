<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<% String ctx = request.getContextPath(); %>

<html>
<jsp:include page="../../commonHeader.jsp" />
<link href="/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="/resources/image/icon/HalfLife.ico" rel="shortcuticon">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="//code.jquery.com/jquery.js"></script>
<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
<script src="/resources/bootstrap/js/respond.js"></script>
<body>

<div class="probootstrap-main">
<section class="probootstrap-section">
<div class="section">
	<div class="container">
		<div class="row" id="table_list">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th class="hidden-xs">글번호</th>
							<th class="hidden-xs">작성자</th>
							<th>제목</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${boardList==null || empty boardList}">
							<tr>
								<td colspan="5">서버오류이거나 데이터가 존재하지 않습니다.</td>
							</tr>
						</c:if>

						<c:if test="${boardList!=null && not empty boardList}">
							<c:forEach var="all_border" items="${boardList}">
								<tr>
									<td class="hidden-xs">${all_border.subject}</td>

									<td class="hidden-xs"><a href="<%=ctx%>/bordermove.do?subject=${all_border.subject}">${all_border.note}</a></td>

									<td>${all_border.remark}</td>

										<c:if test="${all_border.subject=='4'}">
											<th>
												<a class="btn btn-danger" data-toggle="modal"
													data-target="#Delete_Modal" onclick="del('${all_border.subject}')">
												
												삭제
												
												
												</a>
											</th>
										</c:if>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>

					<tr>
						<td colspan="5" class="text-center hidden-xs">
							<ul class="pagination">
								<c:forEach var="i" begin="1" end="${ab_pageCount}" step="1">
									<c:if test="${i == ab_cpage}">
										<li class="active"><a href="#mList">${i}</a></li>
									</c:if>
									<c:if test="${i != ab_cpage}">
										<li><a href="myteam_border.per?ab_cpage=${i}#mList">${i}</a></li>
									</c:if>
								</c:forEach>
							</ul>
						</td>
						<td colspan="3" class="text-center hidden-lg hidden-md hidden-sm">
							<ul class="pagination">
								<c:forEach var="i" begin="1" end="${ab_pageCount}" step="1">
									<c:if test="${i == ab_cpage}">
										<li class="active"><a href="#allList">${i}</a></li>
									</c:if>
									<c:if test="${i != ab_cpage}">
										<li><a href="all_border.per?ab_cpage=${i}#allList">${i}</a></li>
									</c:if>
								</c:forEach>
							</ul>
						</td>
						<td>
							<a class="btn btn-success" href="tripreportwritepage.do">출장보고서 작성</a>
							<a class="btn btn-success" href="testdatainsert.do">test데이터 생성</a>
						</td>
					</tr>
				</table>


			</div>
		</div>
	</div>
</div>
</section>
</div>

<!-- Delete Modal -->
<form id="d_mo" name="d_mo" action="borderdelete.do">
	<div id="Delete_Modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">삭제하시겠습니까?</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal"
						onclick="modal_de()">삭제</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<input  type="text" id=de_subject name="de_subject">
				</div>
			</div>

		</div>
	</div>
</form>

<script src="<c:url value="/resources/js/board/function.js" />"></script>
</body>

<jsp:include page="../../commonFooter.jsp" />
</html>
