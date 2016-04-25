package com.tangz.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tangz.util.JDBCUtil;

public class baseDAO {

	private Object mappingObj(ResultSet rs, Class clazz) throws SQLException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Object obj = clazz.newInstance();
		Method[] methods = clazz.getMethods();
		ResultSetMetaData meta = rs.getMetaData();
		for (int i = 1; i <= meta.getColumnCount(); i++) {
			String colname = meta.getColumnLabel(i);
			String methodname = "set" + colname;
			for (Method method : methods) {
				if (method.getName().toLowerCase().equals(methodname.toLowerCase())) {
					method.invoke(obj, rs.getObject(i));
				}
			}
		}
		return obj;
	}

	public int findTotalRecords(String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			JDBCUtil.free(rs, ps, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public ArrayList findObjsPageList(String sql, Object[] params, Class clazz) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList objs = new ArrayList();
		try {
			conn = JDBCUtil.getConnection();
			String sqlwhere = " limit " + params[0] + " , " + params[1];
			String sqlnew = sql + sqlwhere;
			ps = conn.prepareStatement(sqlnew);
			rs = ps.executeQuery();
			while (rs.next()) {
				Object obj = mappingObj(rs, clazz);
				objs.add(obj);
			}
			JDBCUtil.free(rs, ps, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return objs;
	}

	public ArrayList findObjs(String sql, Object[] params, Class clazz) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList objs = new ArrayList();
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			if (params != null) {
				ParameterMetaData pm = ps.getParameterMetaData();
				for (int i = 1; i <= pm.getParameterCount(); i++) {
					ps.setObject(i, params[i - 1]);
				}
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				Object obj = mappingObj(rs, clazz);
				objs.add(obj);
			}
			JDBCUtil.free(rs, ps, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return objs;
	}

	public Object findObj(String sql, Object[] params, Class clazz) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Object obj = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ParameterMetaData pm = ps.getParameterMetaData();
			for (int i = 1; i <= pm.getParameterCount(); i++) {
				ps.setObject(i, params[i - 1]);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				obj = mappingObj(rs, clazz);
			}
			JDBCUtil.free(rs, ps, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	public int updateObj(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ParameterMetaData pm = ps.getParameterMetaData();
			for (int i = 1; i <= pm.getParameterCount(); i++) {
				ps.setObject(i, params[i - 1]);
			}
			int i = ps.executeUpdate();
			JDBCUtil.free(rs, ps, conn);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
