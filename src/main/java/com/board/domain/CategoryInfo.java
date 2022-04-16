package com.board.domain;

import java.time.LocalDateTime;

public class CategoryInfo {
	private int categoryId;
	private String categoryName;
	private LocalDateTime createDt;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public LocalDateTime getCreateDt() {
		return createDt;
	}
	public void setCreateDt(LocalDateTime createDt) {
		this.createDt = createDt;
	}
	@Override
	public String toString() {
		return "CategoryInfo [categoryId=" + categoryId + ", categoryName=" + categoryName + ", createDt=" + createDt
				+ "]";
	}
}
