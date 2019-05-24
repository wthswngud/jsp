package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

public interface IuserDao {
	public List<UserVO> userList();
}
