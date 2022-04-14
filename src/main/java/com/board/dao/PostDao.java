package com.board.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.dto.PostViewDto;

public class PostDao implements MybatisDao {
	
	/**
	 * 기능 : 게시글 목록 조회
	 * return : List<PostViewDto>
	 * @throws SQLException 
	 */
	public List<PostViewDto> getPostViewList() {
		SqlSession session = factory.openSession(true);
		return session.selectList("post.selectPostView");
	}
	/**
	 * 기능 : 게시글 단일 조회
	 * return : PostViewDto
	 * @throws SQLException 
	 */
	public PostViewDto getPostView(String postId){
		SqlSession session = factory.openSession(true);
		return session.selectOne("post.selectPostView", postId);
	}
}
