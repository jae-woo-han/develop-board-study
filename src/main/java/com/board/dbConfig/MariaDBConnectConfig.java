package com.board.dbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MariaDBConnectConfig implements DBConnentConfig{
    private final String driver = "org.mariadb.jdbc.Driver";
    private final String DB_IP = "localhost";
    private final String DB_PORT = "3306";
    private final String DB_NAME = "board_study";
    private final String DB_URL;

    public MariaDBConnectConfig() {
        this.DB_URL = "jdbc:mariadb://"+DB_IP+":"+DB_PORT+"/"+DB_NAME;

        System.out.println("DB Connection Configulation");
        System.out.println("DRIVER   :   "+driver);
        System.out.println("DB_IP    :   "+DB_IP);
        System.out.println("DB_PORT  :   "+DB_PORT);
        System.out.println("DB_NAME  :   "+DB_NAME);
        System.out.println("DB_URL   :   "+DB_URL);
    }

    @Override
    public Connection connectDB() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = Optional
                    .ofNullable(DriverManager.getConnection(DB_URL,"root","akfldk1elql"))
                    .orElseThrow();
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

	@Override
	public void closeDB(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try{
            if(rs != null)rs.close();
            if(pstmt != null)pstmt.close();
            if(conn != null && !conn.isClosed())conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
	}
}
