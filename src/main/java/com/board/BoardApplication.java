package com.board;

import com.board.dbConfig.DBConnentConfig;
import com.board.dbConfig.MariaDBConnectConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardApplication {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try{
            DBConnentConfig dbConfig = new MariaDBConnectConfig();
            conn = dbConfig.connectDB();

            String insertSQL = "insert into category_info (category_name) values('hello world')";

            pstmt = conn.prepareStatement(insertSQL);

            rs = pstmt.executeQuery();

        }catch (SQLException e){
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
