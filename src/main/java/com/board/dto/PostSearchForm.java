package com.board.dto;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

public class PostSearchForm {
	private String postId;
	private LocalDate fromDt;
	private LocalDate toDt;
	private String categoryId;
	private String searchMessage;
	private String start;
	

	public PostSearchForm(String postId, LocalDate fromDt, LocalDate toDt, String categoryId, String searchMessage,
			String start) {
		this.postId = postId;
		this.fromDt = fromDt;
		this.toDt = toDt;
		this.categoryId = categoryId;
		this.searchMessage = searchMessage;
		this.start = start;
	}
	public static PostSearchFormBuilder builder() {
		return new PostSearchFormBuilder();
	}
	public static class PostSearchFormBuilder{
		private String postId;
		private LocalDate fromDt;
		private LocalDate toDt;
		private String categoryId;
		private String searchMessage;
		private String start;
		
		PostSearchFormBuilder(){}
		
		public PostSearchFormBuilder postId(String postId) {
			this.postId = StringUtils.isEmpty(postId)?null:postId;
			return this;
		}
		public PostSearchFormBuilder fromDt(LocalDate fromDt) {
			this.fromDt = fromDt;
			return this;
		}
		public PostSearchFormBuilder toDt(LocalDate toDt) {
			this.toDt = toDt;
			return this;
		}
		public PostSearchFormBuilder categoryId(String categoryId) {
			this.categoryId = StringUtils.isEmpty(categoryId)?null:categoryId;
			return this;
		}
		public PostSearchFormBuilder searchMessage(String searchMessage) {
			this.searchMessage = StringUtils.isEmpty(searchMessage)?null:searchMessage;
			return this;
		}
		public PostSearchFormBuilder start(String start) {
			int startCalcu= (Integer.parseInt(start)-1)*10;
			this.start = Integer.toString(startCalcu);
			return this;
		}
		
		public PostSearchForm build() {
			return new PostSearchForm(postId, fromDt, toDt, categoryId, searchMessage, start);
		}
	}
	
	public String getPostId() {
		return postId;
	}
	public LocalDate getFromDt() {
		return fromDt;
	}
	public LocalDate getToDt() {
		return toDt;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public String getSearchMessage() {
		return searchMessage;
	}
	public String getStart() {
		return start;
	}

	
}
