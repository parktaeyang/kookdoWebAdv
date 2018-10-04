//package kookdo.conn.serviceimpl;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import kookdo.conn.dao.BoardDAO;
//import kookdo.conn.model.BoardVO;
//import kookdo.conn.service.BoardService;
//
//import org.springframework.stereotype.Service;
//
//@Service("boardService")
//public class BoardServiceImpl implements BoardService{
//	
//	@Resource(name="boardDAO")
//	private BoardDAO boarddao;
//	
//	@Override
//	public List<BoardVO> selectBoard() throws Exception {
//        return boarddao.selectBoard();
//    }
//
//	@Override
//	public int deleteBoard(String subject) throws Exception {
//		return boarddao.deleteBoard(subject);
//	}
//
//	@Override
//	public void insertTestBoard() throws Exception {
//		
//		boarddao.deleteTestBoard();
//		
//		BoardVO test = null; 
//		
//		for(int i=1; i<16; i++){
//			test = new BoardVO();
//			test.setSubject(i+"");
//			test.setNote("test"+i+" insert");
//			test.setRemark("remark"+i+ "insert");
//			boarddao.insertTestBoard(test);
//		}
//	}
//
//}
