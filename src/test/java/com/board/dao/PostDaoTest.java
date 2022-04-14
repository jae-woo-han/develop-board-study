package com.board.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.board.dto.PostViewDto;

class PostDaoTest {
	PostDao dao = new PostDao();
	@Test
	void 게시글단일조회() {
		PostViewDto post = dao.getPostView("1");
		System.out.println(post.toString());
		assertEquals("공지", post.getCategoryName());
	}
	@Test
	void 게시글목록조회() {
		List<PostViewDto> postList = dao.getPostViewList(5);
		assertEquals("공지", postList.get(0).getCategoryName());
	}
	@Test
	void 전체수조회() {
		assertEquals(31, dao.getPostTotalCount());
	}
	

}
