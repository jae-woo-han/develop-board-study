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
import com.board.domain.CategoryInfo;
import com.board.domain.PostInfo;

public class CategoryDao {
private DBConnentConfig dbConfig;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public CategoryDao() {
		this.dbConfig = new MariaDBConnectConfig();
		this.conn = dbConfig.connectDB();
	}
	
	/**
	 * 기능 : 카테고리 전체조회
	 * return : List
	 * @throws SQLException 
	 */
	public List<CategoryInfo> getCategoryAll(){
		String sql = "select category_id, category_name, create_dt from category_info";
		
		List<CategoryInfo> categoryList = new LinkedList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CategoryInfo category = new CategoryInfo();
				category.setCategoryId(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				
				categoryList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConfig.closeDB(conn, pstmt, rs);
		}
		return categoryList;
	}
}
