package com.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.board.domain.PostInfo;
import com.board.dto.PostSearchForm;
import com.board.dto.PostViewDto;

public class PostDao implements MybatisDao {
	
	/**
	 * 기능 : 게시글 목록 조회
	 * return : List<PostViewDto>
	 */
	public List<PostViewDto> getPostViewList(PostSearchForm request) {
		SqlSession session = factory.openSession(true);
		
		return session.selectList("post.selectPostView",request);
	}
	/**
	 * 기능 : 게시글 단일 조회
	 * return : PostViewDto
	 */
	public PostViewDto getPostView(String postId){
		SqlSession session = factory.openSession(true);
		PostSearchForm form = PostSearchForm.builder()
				.postId(postId)
				.build();
		return session.selectOne("post.selectPostView", form);
	}
	
	/**
	 * 기능 : 게시글 전체 수 조회
	 */
	public int getPostCount(PostSearchForm request) {
		SqlSession session = factory.openSession(true);
		return session.selectOne("post.postTotalCount",request);
	}
}
