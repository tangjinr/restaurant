package com.tangz.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DAOFactory {
	static Properties prop;
	
	static {
		prop = new Properties();
		InputStream in = JDBCUtil.class
				.getResourceAsStream("/properties/dao.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object newInstance(String interfaceClassName) {
		String className = prop.getProperty(interfaceClassName);
		try {
			return Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
