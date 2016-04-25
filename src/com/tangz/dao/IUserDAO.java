package com.tangz.dao;

import java.util.ArrayList;

import com.tangz.domain.User;

public interface IUserDAO {
	public ArrayList findUsers();

	public User findUser(Object obj);

	public int insertUser(Object obj);

	public int modifyUser(Object obj);

	public int deleteUser(Object obj);
}