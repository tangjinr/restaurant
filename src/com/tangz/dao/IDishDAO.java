package com.tangz.dao;

import java.util.ArrayList;

import com.tangz.domain.Dish;

public interface IDishDAO {
	
	public ArrayList findDishPageList(int pageNo, int pageSize);
	
	public int findDishRecords();

	public ArrayList findDishes();
	
	public Dish findDishByID(int dishid);

	public int insert(Dish dish);
	
	public int delete(int dishid);
	
	public int update(Dish dish);

}