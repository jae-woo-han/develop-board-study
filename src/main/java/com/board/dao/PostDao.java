package com.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.board.dto.PostViewDto;

public class PostDao implements MybatisDao {
	
	/**
	 * 기능 : 게시글 목록 조회
	 * return : List<PostViewDto>
	 */
	public List<PostViewDto> getPostViewList(int start) {
		SqlSession session = factory.openSession(true);
		
		Map<String, String> paramMap = new HashMap<>();
		int startPost = (start-1)*10;
		paramMap.put("start", Integer.toString(startPost));
		return session.selectList("post.selectPostView",paramMap);
	}
	/**
	 * 기능 : 게시글 단일 조회
	 * return : PostViewDto
	 */
	public PostViewDto getPostView(String postId){
		SqlSession session = factory.openSession(true);
		return session.selectOne("post.selectPostView", postId);
	}
	
	/**
	 * 기능 : 게시글 전체 수 조회
	 */
	public int getPostTotalCount() {
		SqlSession session = factory.openSession(true);
		return session.selectOne("post.postTotalCount");
	}
}
