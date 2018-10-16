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
						<form name="businesstripreport" id="businesstripreport" action="tripreportwrite.do" method="post">
							<table id="table_info" class="table">
								<tr>
									<td bgcolor='#E6E6E6'>출장일정</td>
									<td>
										<input type="text" class="form-control" id="trip_schedule" name="trip_schedule">
									</td>
									<td bgcolor='#E6E6E6'>작성자/동행자</td>
									<td>
										<input type="text" class="form-control" id="trip_member" name="trip_member">
									</td>
									<td bgcolor='#E6E6E6'>작성일자</td>
									<td>
										<input type="text" class="form-control" id="trip_write_date" name="trip_write_date">
									</td>
								</tr>
								<tr>
									<td colspan="6"></td>
								</tr>
								<tr>
									<td colspan="6">▶고객정보</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>상호/고객명</td>
									<td>
										<input type="text" class="form-control" id="trip_customer" name="trip_customer">
									</td>
									<td bgcolor='#E6E6E6'>주소</td>
									<td colspan="3">
										<input type="text" class="form-control" id="trip_addr" name="trip_addr">
									</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>연락처</td>
									<td>
										<input type="text" class="form-control" id="trip_phone" name="trip_phone">
									</td>
									<td bgcolor='#E6E6E6'>T E L</td>
									<td>
										<input type="text" class="form-control" id="trip_tel" name="trip_tel">
									</td>
									<td bgcolor='#E6E6E6'>F A X</td>
									<td>
										<input type="text" class="form-control" id="trip_fax" name="trip_fax">
									</td>
								</tr>
								<tr>
									<td colspan="6"></td>
								</tr>
								<tr>
									<td colspan="6">▶소요비용</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>소요시간</td>
									<td>
										<input type="text" class="form-control" id="trip_consum_time" name="trip_consum_time">
									</td>
									<td bgcolor='#E6E6E6'>거 리</td>
									<td>
										<input type="text" class="form-control" id="trip_distance" name="trip_distance">
									</td>
									<td bgcolor='#E6E6E6'>기 타</td>
									<td>
										<input type="text" class="form-control" id="trip_etc" name="trip_etc">
									</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>숙박/식대</td>
									<td>
										<input type="text" class="form-control" id="trip_meal_fee" name="trip_meal_fee">
									</td>
									<td bgcolor='#E6E6E6'>유류비</td>
									<td>
										<input type="text" class="form-control" id="trip_oil_fee" name="trip_oil_fee">
									</td>
									<td bgcolor='#E6E6E6'>금액합계</td>
									<td>
										<input type="text" class="form-control" id="trip_total_price" name="trip_total_price">
									</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>부품비</td>
									<td>
										<input type="text" class="form-control" id="trip_part_fee" name="trip_part_fee">
									</td>
									<td bgcolor='#E6E6E6'>통행료</td>
									<td>
										<input type="text" class="form-control" id="trip_toll_fee" name="trip_toll_fee">
									</td>
									<td bgcolor='#E6E6E6'>비 고 </td>
									<td>
										<input type="text" class="form-control" id="trip_remark" name="trip_remark">
									</td>
								</tr>
								<tr>
									<td colspan="6"></td>
								</tr>
								<tr>
									<td colspan="6">▶기계정보</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>품 명</td>
									<td>
										<input type="text" class="form-control" id="trip_goods" name="trip_goods">
									</td>
									<td bgcolor='#E6E6E6'>규 격</td>
									<td>
										<input type="text" class="form-control" id="trip_standard" name="trip_standard">
									</td>
									<td bgcolor='#E6E6E6'>구 분</td>
									<td>
										<input type="text" class="form-control" id="trip_division" name="trip_division">
									</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>제조사/년식</td>
									<td>
										<input type="text" class="form-control" id="trip_manufacturer" name="trip_manufacturer">
									</td>
									<td bgcolor='#E6E6E6'>컨트롤러</td>
									<td>
										<input type="text" class="form-control" id="trip_controller" name="trip_controller">
									</td>
									<td bgcolor='#E6E6E6'>시리얼번호</td>
									<td>
										<input type="text" class="form-control" id="trip_serial_num" name="trip_serial_num">
									</td>
								</tr>
								<tr>
									<td colspan="6"></td>
								</tr>
							</table>
							
							<table id="table_check" class="table">
								<tr>
									<td colspan="3">▶점검 및 수리 내역</td>
								</tr>
								
								<tr>
									<td rowspan="3" width="10%" bgcolor='#E6E6E6'>기계 PART</td>
								</tr>
								<tr>
									<td>원인 : <input type="text" class="form-control" id="trip_machine_cause" name="trip_machine_cause"></td>
								</tr>
								<tr>
									<td>조치 : <input type="text" class="form-control" id="trip_machine_action" name="trip_machine_action"></td>
								</tr>
								
								<tr>
									<td rowspan="3" bgcolor='#E6E6E6'>유압 PART</td>
								</tr>
								<tr>
									<td>원인 : <input type="text" class="form-control" id="trip_hydraulics_cause" name="trip_hydraulics_cause"></td>
								</tr>
								<tr>
									<td>조치 : <input type="text" class="form-control" id="trip_hydraulics_action" name="trip_hydraulics_action"></td>
								</tr>
								
								<tr>
									<td rowspan="3" bgcolor='#E6E6E6'>전기전장 PART</td>
								</tr>
								<tr>
									<td>원인 : <input type="text" class="form-control" id="trip_electric_field_cause" name="trip_electric_field_cause"></td>
								</tr>
								<tr>
									<td>조치 : <input type="text" class="form-control" id="trip_electric_field_action" name="trip_electric_field_action"></td>
								</tr>
								
								<tr>
									<td rowspan="3" bgcolor='#E6E6E6'>금형 PART</td>
								</tr>
								<tr>
									<td>원인 : <input type="text" class="form-control" id="trip_mold_cause" name="trip_mold_cause"></td>
								</tr>
								<tr>
									<td>조치 : <input type="text" class="form-control" id="trip_mold_action" name="trip_mold_action"></td>
								</tr>
								
								<tr>
									<td rowspan="3" bgcolor='#E6E6E6'>기타</td>
								</tr>
								<tr>
									<td>원인 : <input type="text" class="form-control" id="trip_etc_cause" name="trip_etc_cause"></td>
								</tr>
								<tr>
									<td>조치 : <input type="text" class="form-control" id="trip_etc_action" name="trip_etc_action"></td>
								</tr>
								
							</table>
							
							<table id="table_check" class="table">
								<tr>
									<td colspan="3">▶점검 및 수리 내역</td>
								</tr>
								<tr>
									<td rowspan="6" width="8%" bgcolor='#E6E6E6'>X축</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6' width="10%">서보모터</td>
									<td><input type="text" class="form-control" id="trip_x_servo" name="trip_x_servo"></td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>볼스크류</td>
									<td><input type="text" class="form-control" id="trip_x_ballscrew" name="trip_x_ballscrew"></td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>볼너트</td>
									<td><input type="text" class="form-control" id="trip_x_bolleoteu" name="trip_x_bolleoteu"></td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>벨트</td>
									<td><input type="text" class="form-control" id="trip_x_belt" name="trip_x_belt"></td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>LM레일/블럭</td>
									<td><input type="text" class="form-control" id="trip_x_lm" name="trip_x_lm"></td>
								</tr>
								
								<tr>
									<td rowspan="6" bgcolor='#E6E6E6'>R축</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>서보모터</td>
									<td><input type="text" class="form-control" id="trip_r_servo" name="trip_r_servo"></td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>볼스크류</td>
									<td><input type="text" class="form-control" id="trip_r_ballscrew" name="trip_r_ballscrew"></td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>볼너트</td>
									<td><input type="text" class="form-control" id="trip_r_bolleoteu" name="trip_r_bolleoteu"></td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>벨트</td>
									<td><input type="text" class="form-control" id="trip_r_belt" name="trip_r_belt"></td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>LM레일/블럭</td>
									<td><input type="text" class="form-control" id="trip_r_lm" name="trip_r_lm"></td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6' colspan="2">모 터</td>
									<td><input type="text" class="form-control" id="trip_mortor" name="trip_mortor"></td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6' colspan="2">펌 프</td>
									<td><input type="text" class="form-control" id="trip_pump" name="trip_pump"></td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6' colspan="2">쿨러/히터/칠러</td>
									<td><input type="text" class="form-control" id="trip_chc_ler" name="trip_chc_ler"></td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6' colspan="2">스케일</td>
									<td><input type="text" class="form-control" id="trip_scale" name="trip_scale"></td>
								</tr>
							</table>
								
							<table class="table">
								<tr>
									<td bgcolor='#E6E6E6' width="10%">업무조치 세부사항</td>
									<td colspan="3">
										<input type="text" class="form-control" id="trip_action_detail" name="trip_action_detail">
									</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6'>추가예정 업무사항</td>
									<td colspan="3">
										<input type="text" class="form-control" id="trip_add_schedule" name="trip_add_schedule">
									</td>
								</tr>
								<tr>
									<td bgcolor='#E6E6E6' rowspan="3">청구사항</td>
								</tr>
								<tr>
									<td width="5%">유상</td>
									<td width="10%">견적서첨부</td>
									<td><input type="text" class="form-control" id="trip_fee_quotation" name="trip_fee_quotation"></td>
								</tr>
								<tr>
									<td>무상</td>
									<td>무상사유</td>
									<td><input type="text" class="form-control" id="trip_free_reason" name="trip_free_reason"></td>
								</tr>
							</table>
							
							<div class="form-group text-center">
								<button type="button" class="btn btn-info" onclick="businesstripreport_write()">
									작성 <i class="fa fa-check spaceLeft"></i>
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
<script src="<c:url value="/resources/js/board/function.js" />"></script>
</body>

<jsp:include page="../../commonFooter.jsp" />
</body>
</html>