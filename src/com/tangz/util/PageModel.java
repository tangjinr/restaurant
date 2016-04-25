package com.tangz.util;

import java.util.List;

public class PageModel {
	// ��¼��Ŀ
	private int totalrecords;
	// ÿҳ��¼��
	private int pageSize;
	// ��ǰҳ��
	private int pageNO;
	// �����
	private List list;

	public PageModel(int totalrecords, int pageSize, int pageNo, List list) {
		this.totalrecords = totalrecords;
		this.pageSize = pageSize;
		this.pageNO = pageNo;
		this.list = list;
	}

	/**
	 * ��ҳ��
	 * 
	 * @return
	 */
	public int getTotalPages() {
		return (totalrecords + pageSize - 1) / pageSize;
	}

	/**
	 * ��һҳ
	 * 
	 * @return
	 */
	public int getTopPageNO() {
		return 1;
	}

	/**
	 * ��һҳ
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
	 * ��һҳ
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
	 * ���һҳ
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
