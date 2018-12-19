package kookdo.com.board.tripreport;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kookdo.com.board.BoardDAO;
import kookdo.conn.model.ReportTripVO;
/**
 * Servlet implementation class TripReportController
 */
@WebServlet("/tripreport_list.do")
public class TripReportListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TripReportListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
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
