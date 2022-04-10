<%@page import="java.sql.SQLException"%>
<%@page import="com.board.dbConfig.MariaDBConnectConfig"%>
<%@page import="com.board.dbConfig.DBConnentConfig"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import = "com.board.domain.*" %>
<%
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
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World!</title>
</head>
<body>
    <h1>Hello World!</h1>
    <p><%= category.getCategoryName() %> </p>
</body>
</html>