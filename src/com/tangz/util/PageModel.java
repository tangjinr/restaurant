package com.tangz.util;

import java.util.List;

public class PageModel {
	// 记录数目
	private int totalrecords;
	// 每页记录数
	private int pageSize;
	// 当前页号
	private int pageNO;
	// 结果集
	private List list;

	public PageModel(int totalrecords, int pageSize, int pageNo, List list) {
		this.totalrecords = totalrecords;
		this.pageSize = pageSize;
		this.pageNO = pageNo;
		this.list = list;
	}

	/**
	 * 总页数
	 * 
	 * @return
	 */
	public int getTotalPages() {
		return (totalrecords + pageSize - 1) / pageSize;
	}

	/**
	 * 第一页
	 * 
	 * @return
	 */
	public int getTopPageNO() {
		return 1;
	}

	/**
	 * 上一页
	 * 
	 * @return
	 */
	public int getPrevPageNO() {
		if (pageNO <= 1) {
			return 1;
		}
		return pageNO - 1;
	}

	/**
	 * 下一页
	 * 
	 * @return
	 */
	public int getNextPageNO() {
		if (pageNO >= getTotalPages()) {
			return getTotalPages();
		}
		return pageNO + 1;
	}

	/**
	 * 最后一页
	 * 
	 * @return
	 */
	public int getBottomPageNO() {
		return getTotalPages();
	}

	public int getTotalrecords() {
		return totalrecords;
	}

	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNO() {
		return pageNO;
	}

	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
