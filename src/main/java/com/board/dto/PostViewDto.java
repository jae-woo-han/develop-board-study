package com.board.dto;

import java.time.LocalDateTime;
/**
 * 
 * @author jaewoo
 * 
 * 게시글 표시 위한 DTO
 */
public class PostViewDto {
	private int postId;
	private String categoryName;
	private int fileCount;
	private String title;
	private String postContent;
	private String writer;
	private LocalDateTime writeDt;
	private LocalDateTime updateDt;
	private int viewCount;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getFileCount() {
		return fileCount;
	}
	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
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
		return "PostViewDto [postId=" + postId + ", categoryName=" + categoryName + ", fileCount=" + fileCount
				+ ", title=" + title + ", postContent=" + postContent + ", writer=" + writer + ", writeDt=" + writeDt
				+ ", updateDt=" + updateDt + ", viewCount=" + viewCount + "]";
	}
	
}
