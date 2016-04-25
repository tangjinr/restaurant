package com.tangz.dao;

import java.util.ArrayList;

import com.tangz.domain.User;

public class UserDAOSqlImpl extends baseDAO implements IUserDAO {
	
	private String sql = null;
	private Object[] params = null;
	private String userName = null;
	private String userPwd = null;
	private User user = null;

	@Override
	public ArrayList findUsers() {
		sql = "select * from userInfo";
		return findObjs(sql, null, User.class);
	}

	@Override
	public User findUser(Object obj) {
		sql = "select * from userInfo where userName=? and userPwd=?";
		user = (User) obj;
		userName = user.getUserName();
		userPwd = user.getUserPwd();
		params = new Object[]{userName, userPwd};
		return (User)findObj(sql, params, User.class);
	}

	@Override
	public int insertUser(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyUser(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
