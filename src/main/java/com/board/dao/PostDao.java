package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.board.dbConfig.DBConnentConfig;
import com.board.dbConfig.MariaDBConnectConfig;
import com.board.domain.PostInfo;

public class PostDao {
	private DBConnentConfig dbConfig;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public PostDao() {
		this.dbConfig = new MariaDBConnectConfig();
		this.conn = dbConfig.connectDB();
	}
	
	/**
	 * 기능 : 게시글 목록 조회
	 * return : List
	 * @throws SQLException 
	 */
	public List<PostInfo> getPostList() {
		String sql = "select post_id, category_id, title, post_content, writer, write_dt, update_dt from post_info";
		List<PostInfo> postList = new LinkedList<PostInfo>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostInfo post = new PostInfo();
				post.setPostId(rs.getInt(1));
				post.setCategoryId(rs.getInt(2));
				post.setTitle(rs.getString(3));
				post.setPostContent(rs.getString(4));
				post.setWriter(rs.getString(5));
				Date writeDt = rs.getDate(6);
				post.setWriteDt(new Timestamp(writeDt.getTime()).toLocalDateTime());
				Date updateDt = rs.getDate(7);
				post.setUpdateDt(new Timestamp(updateDt.getTime()).toLocalDateTime());
				
				postList.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConfig.closeDB(conn, pstmt, rs);
		}
		return postList;
	}
}
