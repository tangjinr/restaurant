package com.tangz.dao;

import java.util.ArrayList;

import com.tangz.domain.Dish;

public class DishDAOImpl extends baseDAO implements IDishDAO {
	private String sql = null;

	@Override
	public ArrayList findDishes() {
		sql = "select dishid Dishid,dishname Dishname,dishdesc Dishdesc,img Img, price Price from dish;";
		return findObjs(sql, null, Dish.class);
	}

	@Override
	public Dish findDishByID(int dishid) {
		sql = "select dishid Dishid,dishname Dishname,dishdesc Dishdesc,img Img, price Price from dish where dishid=?";
		Object[] params = { dishid };
		return (Dish) findObj(sql, params, Dish.class);
	}

	@Override
	public ArrayList findDishPageList(int pageNo, int pageSize) {
		//String sql = "select dishid Dishid, name Dishname, description Dishdesc, img Img, price Price from ( select row_number() over (order by dishid) rownum, * from dish )  t1  ";
		String sql = "select * from dish";
		int M = (pageNo - 1) * pageSize;
		int N = pageSize;
		//int offset = M + N - 1;
		Object[] params = { M, N };
		return findObjsPageList(sql, params, Dish.class);
	}

	@Override
	public int findDishRecords() {
		String sql = "select count(*) from dish";
		return findTotalRecords(sql);
	}

	@Override
	public int insert(Dish dish) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int dishid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Dish dish) {
		// TODO Auto-generated method stub
		return 0;
	}

}
