package com.tangz.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	private String driver;
	private String url;
	private String sqlName;
	private String sqlPwd;
	private static JDBCUtil instance = new JDBCUtil();

	private JDBCUtil() {
		InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream(
				"properties/dbconfig.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			sqlName = prop.getProperty("username");
			sqlPwd = prop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JDBCUtil getInstance() {
		return instance;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public String getLoginuser() {
		return sqlName;
	}

	public String getPwd() {
		return sqlPwd;
	}

	public static Connection getConnection() {

		try {
			Class.forName(instance.getDriver());
			return DriverManager.getConnection(instance.getUrl(),
					instance.getLoginuser(), instance.getPwd());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void free(ResultSet rs, PreparedStatement ps, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps != null)
						ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
