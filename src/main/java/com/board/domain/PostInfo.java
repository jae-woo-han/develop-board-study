package com.board.domain;

import java.time.LocalDateTime;

public class PostInfo {
	private int postId;
	private int categoryId;
	private String title;
	private String postContent;
	private String writer;
	private String password;
	private LocalDateTime writeDt;
	private LocalDateTime updateDt;
	private int viewCount;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getWriteDt() {
		return writeDt;
	}
	public void setWriteDt(LocalDateTime writeDt) {
		this.writeDt = writeDt;
	}
	public LocalDateTime getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(LocalDateTime updateDt) {
		this.updateDt = updateDt;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	@Override
	public String toString() {
		return "PostInfo [postId=" + postId + ", categoryId=" + categoryId + ", title=" + title + ", postContent="
				+ postContent + ", writer=" + writer + ", password=" + password + ", writeDt=" + writeDt + ", updateDt="
				+ updateDt + ", viewCount=" + viewCount + "]";
	}
}
