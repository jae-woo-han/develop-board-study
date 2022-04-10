package com.board;

import com.board.dbConfig.DBConnentConfig;
import com.board.dbConfig.MariaDBConnectConfig;
import com.board.domain.PostInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BoardApplication {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        DBConnentConfig dbConfig = new MariaDBConnectConfig();
        conn = dbConfig.connectDB();

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
			System.out.println(postList.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try{
                if(rs != null)rs.close();
                if(pstmt != null)pstmt.close();
                if(conn != null && !conn.isClosed())conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }
}
