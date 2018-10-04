package kookdo.conn.service;

import kookdo.conn.model.UserVO;

public interface UserService {
	
	public UserVO login(String userId) throws Exception;
	
}
