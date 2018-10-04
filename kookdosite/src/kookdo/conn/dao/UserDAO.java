//package kookdo.conn.dao;
//
//import javax.inject.Inject;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.stereotype.Repository;
//
//import kookdo.conn.model.UserVO;
//
//@Repository
//public class UserDAO {
//
//
//	@Inject
//    private SqlSession sqlSession;
//    
//    public UserVO login(String userId) throws Exception {
//
//    	return sqlSession.selectOne("user.login", userId);
//    }
//}