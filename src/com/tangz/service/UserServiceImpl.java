package com.tangz.service;

import java.util.ArrayList;

import com.tangz.dao.IUserDAO;
import com.tangz.domain.User;
import com.tangz.util.DAOFactory;

public class UserServiceImpl implements UserService {
	private IUserDAO userdao = null;
	private User users = null;

	public boolean validateUser(User user) {
		userdao = (IUserDAO) DAOFactory.newInstance("com.tangz.dao.IUserDAO");
		users = userdao.findUser(user);
		if (users != null) {
			return true;
		}
		return false;
	}
}
