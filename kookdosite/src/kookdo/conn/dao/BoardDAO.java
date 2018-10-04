//package kookdo.conn.dao;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.stereotype.Repository;
//
//import kookdo.conn.model.BoardVO;
//
//@Repository
//public class BoardDAO {
//	
//	@Inject
//    private SqlSession sqlSession;
//	
//    public List<BoardVO> selectBoard() throws Exception {
//        return sqlSession.selectList("sql.selectBoard", null);
//    }
//
//	public int deleteBoard(String subject) {
//		return sqlSession.delete("sql.deleteBoard", subject);
//	}
//
//	public int insertTestBoard(BoardVO boardvo) {
//		return sqlSession.insert("sql.insertTestBoard", boardvo);
//	}
//
//	public void deleteTestBoard() {
//		sqlSession.delete("sql.deleteTestBoard", null);
//	}
//
//}
