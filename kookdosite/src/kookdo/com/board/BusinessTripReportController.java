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
//import kookdo.common.AbstractAction;
//import kookdo.conn.model.BoardVO;
//import kookdo.conn.service.BoardService;
//
//@Controller
//public class BusinessTripReportController{
//	
//	@Resource(name="boardService")
//	private BoardService boardService;
//
//	@RequestMapping(value = "businesstripreport", method = RequestMethod.GET)
//	public String businessTripReport(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		System.out.println("businessTripReport execute");
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
//	@RequestMapping(value = "borderdelete", method = RequestMethod.POST)
//	public String borderDelete(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		System.out.println("borderDelete execute");
//		
//		int excute = boardService.deleteBoard(req.getParameter("de_subject"));
//		if(excute < 1) {
//			req.setAttribute("errorMessage", "�궘�젣�뿉 �떎�뙣 �뻽�뒿�땲�떎.");
//			return "../home";
//		}
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
//	@RequestMapping(value = "bordermove", method = RequestMethod.GET)
//	public String borderMove(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		System.out.println("borderMove execute");
//		System.out.println(req.getParameter("subject"));
//		
//		return "board/businesstripreport_list";
//	}
//	
//	@RequestMapping(value = "borderwritemove", method = RequestMethod.GET)
//	public String borderWriteMove(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		System.out.println("borderWriteMove execute");
//		
//		req.setAttribute("test", "34234234324234");
//		
//		return "board/businesstripreport_write";
//	}
//	
//	@RequestMapping(value = "testdatainsert", method = RequestMethod.GET)
//	public String testDataInsert(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		System.out.println("testDataInsert execute");
//		
//		boardService.insertTestBoard();
//		List<BoardVO> boardList = boardService.selectBoard();
//		
//		req.setAttribute("boardList", boardList);
//		
//		return "board/businesstripreport_list";
//	}
//	
//}
