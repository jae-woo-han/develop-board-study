package com.board.dbConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface DBConnentConfig {
    public Connection connectDB();
    public void closeDB(Connection conn, PreparedStatement pstmt, ResultSet rs);
}
