package kookdo.com.board.tripreport;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kookdo.conn.model.ReportTripVO;

import kookdo.com.board.BoardDAO;

/**
 * Servlet implementation class TripReportWriteController
 */
@WebServlet("/tripreportwrite.do")
public class TripReportWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDAO boardDAO = new BoardDAO();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ReportTripVO reporttrip = new ReportTripVO();
		
		reporttrip.setTrip_schedule((String)request.getParameter("trip_schedule"));
		reporttrip.setTrip_member((String)request.getParameter("trip_member"));
		reporttrip.setTrip_action_detail((String)request.getParameter("trip_action_detail"));
		reporttrip.setTrip_add_schedule((String)request.getParameter("trip_add_schedule"));
		reporttrip.setTrip_addr((String)request.getParameter("trip_addr"));
		reporttrip.setTrip_chc_ler((String)request.getParameter("trip_chc_ler"));
		reporttrip.setTrip_consum_time((String)request.getParameter("trip_consum_time"));
		reporttrip.setTrip_controller((String)request.getParameter("trip_controller"));
		reporttrip.setTrip_customer((String)request.getParameter("trip_customer"));
		reporttrip.setTrip_distance((String)request.getParameter("trip_distance"));
		reporttrip.setTrip_division((String)request.getParameter("trip_division"));
		reporttrip.setTrip_electric_field_action((String)request.getParameter("trip_electric_field_action"));
		reporttrip.setTrip_electric_field_cause((String)request.getParameter("trip_electric_field_cause"));
		reporttrip.setTrip_fax((String)request.getParameter("trip_fax"));
		reporttrip.setTrip_fee_quotation((String)request.getParameter("trip_fee_quotation"));
		reporttrip.setTrip_free_reason((String)request.getParameter("trip_free_reason"));
		reporttrip.setTrip_goods((String)request.getParameter("trip_goods"));
		reporttrip.setTrip_hydraulics_action((String)request.getParameter("trip_hydraulics_action"));
		reporttrip.setTrip_hydraulics_cause((String)request.getParameter("trip_hydraulics_cause"));
		reporttrip.setTrip_machine_action((String)request.getParameter("trip_machine_action"));
		reporttrip.setTrip_machine_cause((String)request.getParameter("trip_machine_cause"));
		reporttrip.setTrip_manufacturer((String)request.getParameter("trip_manufacturer"));
		reporttrip.setTrip_meal_fee((String)request.getParameter("trip_meal_fee"));
		reporttrip.setTrip_member((String)request.getParameter("trip_member"));
		reporttrip.setTrip_mold_action((String)request.getParameter("trip_mold_action"));
		reporttrip.setTrip_mold_cause((String)request.getParameter("trip_mold_cause"));
		reporttrip.setTrip_mortor((String)request.getParameter("trip_mortor"));
		reporttrip.setTrip_oil_fee((String)request.getParameter("trip_oil_fee"));
		reporttrip.setTrip_part_fee((String)request.getParameter("trip_part_fee"));
		reporttrip.setTrip_phone((String)request.getParameter("trip_phone"));
		reporttrip.setTrip_pump((String)request.getParameter("trip_pump"));
		reporttrip.setTrip_r_ballscrew((String)request.getParameter("trip_r_ballscrew"));
		reporttrip.setTrip_r_belt((String)request.getParameter("trip_r_belt"));
		reporttrip.setTrip_r_bolleoteu((String)request.getParameter("trip_r_bolleoteu"));
		reporttrip.setTrip_r_lm((String)request.getParameter("trip_r_lm"));
		reporttrip.setTrip_r_servo((String)request.getParameter("trip_r_servo"));
		reporttrip.setTrip_remark((String)request.getParameter("trip_remark"));
		reporttrip.setTrip_scale((String)request.getParameter("trip_scale"));
		reporttrip.setTrip_schedule((String)request.getParameter("trip_schedule"));
		reporttrip.setTrip_serial_num((String)request.getParameter("trip_serial_num"));
		reporttrip.setTrip_standard((String)request.getParameter("trip_standard"));
		reporttrip.setTrip_tel((String)request.getParameter("trip_tel"));
		reporttrip.setTrip_toll_fee((String)request.getParameter("trip_toll_fee"));
		reporttrip.setTrip_total_price((String)request.getParameter("trip_total_price"));
		reporttrip.setTrip_write_date((String)request.getParameter("trip_write_date"));
		reporttrip.setTrip_x_ballscrew((String)request.getParameter("trip_x_ballscrew"));
		reporttrip.setTrip_x_belt((String)request.getParameter("trip_x_belt"));
		reporttrip.setTrip_x_bolleoteu((String)request.getParameter("trip_x_bolleoteu"));
		reporttrip.setTrip_x_lm((String)request.getParameter("trip_x_lm"));
		reporttrip.setTrip_x_servo((String)request.getParameter("trip_x_servo"));
		
		int result = boardDAO.insertTripReport(reporttrip);
		
		String msg = (result > 0) ? "작성완료" : "작성실패";
		
		request.setAttribute("msg", msg);
		
		String cpStr = request.getParameter("ab_cpage");
		
		if(cpStr==null || cpStr.trim().isEmpty()){
			cpStr = "1";
		}
		
		int ab_cpage = Integer.parseInt(cpStr);
		if(ab_cpage<=0){
			ab_cpage=1;
		}
		
		BoardDAO board_dao = new BoardDAO();
		int ab_totalCount = board_dao.getTotalCount();
		
		int pageSize = 3;
		int ab_pageCount = (ab_totalCount-1)/pageSize+1;
		
		if(ab_cpage > ab_pageCount){
			ab_cpage=ab_pageCount;
		}
		
		int end = ab_cpage*pageSize;
		int start = end-(pageSize-1);
		
		ArrayList<ReportTripVO> boardList = board_dao.selectAllBoardTripreport(start, end);
		
		request.setAttribute("ab_totalCount", ab_totalCount);
		request.setAttribute("ab_pageCount", ab_pageCount);
		request.setAttribute("ab_cpage", ab_cpage);
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/board/businesstripreport_list.jsp");
		dispatcher.forward(request, response);
	}
	
}
