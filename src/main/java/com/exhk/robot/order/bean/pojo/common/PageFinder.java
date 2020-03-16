package com.exhk.robot.order.bean.pojo.common;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PageFinder<T> implements Serializable{
	
    private final static int PAGE_SIZE = 10;
    
    private int pageSize=PageFinder.PAGE_SIZE; // 每页显示的行数;
	
	private int pageNum = 1;

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
