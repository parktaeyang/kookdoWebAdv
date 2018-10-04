//package kookdo.com.board;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import kookdo.conn.model.BoardVO;
//import kookdo.conn.service.BoardService;
//
//@Controller
//public class BusinessTripReportWriteController{
//	
//	@Resource(name="boardService")
//	private BoardService boardService;
//
//	@RequestMapping(value = "businesstripreportwrite", method = RequestMethod.POST)
//	public String businessTripReport(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		System.out.println("businesstripreportwrite execute");
//		
//		
//		
//		
//		List<BoardVO> boardList = boardService.selectBoard();
//		
//		String cpStr = req.getParameter("ab_cpage");
//		if(cpStr==null || cpStr.trim().isEmpty()){
//			cpStr = "1";
//		}
//		
//		int ab_cpage = Integer.parseInt(cpStr);
//		if(ab_cpage<=0){
//			ab_cpage=1;
//		}
//		
//		int ab_totalCount = 15;
//		int pageSize = 5;
//		int ab_pageCount = (ab_totalCount-1)/pageSize+1;
//		if(ab_cpage > ab_pageCount){
//			ab_cpage=ab_pageCount;
//		}
//		
//		req.setAttribute("boardList", boardList);
//		req.setAttribute("ab_totalCount", ab_totalCount);
//		req.setAttribute("ab_pageCount", ab_pageCount);
//		req.setAttribute("ab_cpage", ab_cpage);
//		
//		return "board/businesstripreport_list";
//	}
//	
//}
