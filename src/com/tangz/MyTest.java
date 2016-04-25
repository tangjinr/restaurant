package com.tangz;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.tangz.util.DAOFactory;
import com.tangz.util.JDBCUtil;

public class MyTest {
	
	JDBCUtil jdbcutil = JDBCUtil.getInstance();

	@Test
	public void testNewInstance() {
		assertNotNull(DAOFactory.newInstance("com.tangz.dao.IUserDAO"));
	}
	
	@Test
	public void testGetConnection() {
		assertNotNull(jdbcutil.getConnection());
	}

}
