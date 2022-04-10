package com.board.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.board.domain.PostInfo;

class PostDaoTest {
	PostDao dao = new PostDao();
	@Test
	void 게시글목록조회() {
		PostDao postDao = new PostDao();
		List<PostInfo> postList = postDao.getPostList();
		
		assertEquals("sample", postList.get(0).getTitle());
	}

}
