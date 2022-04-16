package com.board.domain;

import java.time.LocalDateTime;

public class CommentInfo {
	private int commentId;
	private int postId;
	private String commentContent;
	private LocalDateTime writeDt;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public LocalDateTime getWriteDt() {
		return writeDt;
	}
	public void setWriteDt(LocalDateTime writeDt) {
		this.writeDt = writeDt;
	}
	@Override
	public String toString() {
		return "CommentInfo [commentId=" + commentId + ", postId=" + postId + ", commentContent=" + commentContent
				+ ", writeDt=" + writeDt + "]";
	}
}
