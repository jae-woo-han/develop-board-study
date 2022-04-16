package com.board.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.board.domain.PostInfo;
import com.board.dto.PostSearchForm;
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
		PostSearchForm searchForm = PostSearchForm.builder()
				.start("1")
				.build();
		
		List<PostViewDto> postList = dao.getPostViewList(searchForm);
		assertEquals("JAVA", postList.get(0).getCategoryName());
	}
	@Test
	void 전체수조회() {
		PostSearchForm searchForm = PostSearchForm.builder()
				.categoryId("1")
				.build();
		assertEquals(31, dao.getPostCount(searchForm));
	}
	@Test
	void 게시글등록() {
		PostInfo postInfo = new PostInfo();
		//postInfo.setPostId(32);
		postInfo.setCategoryId(1);
		postInfo.setWriter("writ");
		postInfo.setPassword("12345");
		postInfo.setTitle("제목");
		postInfo.setPostContent("내용내용내용");
		
		int res = dao.insertPostInfo(postInfo);
		
		assertTrue(res==40,Integer.toString(res));
	}

}
