package com.board.dto;

import java.util.List;

public class PageDto<T> {
	private int totalCount;
	private int totalPage;
	private int viewingPage=1;
	private List<T> data;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		int dividePage = totalCount/10;
		this.totalPage = (totalCount%10>0?dividePage+1:dividePage);
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getViewingPage() {
		return viewingPage;
	}
	public void setViewingPage(int viewingPage) {
		this.viewingPage = viewingPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}
