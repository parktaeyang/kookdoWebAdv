package kookdo.com.board.tripreport;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kookdo.conn.model.board.ReportTrip;

import kookdo.com.board.BoardDAO;

/**
 * Servlet implementation class TripReportWriteController
 */
@WebServlet("/tripreportwrite.do")
public class TripReportWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDAO boardDAO = new BoardDAO();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReportTrip reporttrip = new ReportTrip();
		
		reporttrip.setBoard_seq(1);
		reporttrip.setTrip_schedule((String)request.getAttribute("trip_schedule"));
		reporttrip.setTrip_member((String)request.getAttribute("trip_member"));
		
		int result = boardDAO.insertTripReport(reporttrip);
		
		String msg = (result > 0) ? "글작성성공" : "글작성실패";
		
		request.setAttribute("msg", msg);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/board/businesstripreport_list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
