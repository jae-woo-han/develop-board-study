<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="com.board.domain.PostInfo"%>
<%@page import="com.board.dao.PostDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String categoryId = request.getParameter("category");
	String writer = request.getParameter("writer");
	String password = request.getParameter("password");
	String passwordConfirm = request.getParameter("passwordConfirm");
	String title = request.getParameter("title");
	String postContent = request.getParameter("postContent");
	//길이 양식 validate
	if(StringUtils.isEmpty(categoryId))response.sendRedirect("writePost.jsp");
	int writeLength = writer.length();
	if(StringUtils.isEmpty(writer)||(writeLength<2&&writeLength<5))response.sendRedirect("writePost.jsp");
	int passwordLength = password.length();
	if(StringUtils.isEmpty(password)||(passwordLength<3&&passwordLength<16))response.sendRedirect("writePost.jsp");
	int titleLength = title.length();
	if(StringUtils.isEmpty(title)||(titleLength<3&&titleLength<100))response.sendRedirect("writePost.jsp");
	int contentLength = postContent.length();
	if(StringUtils.isEmpty(postContent)||(contentLength<3&&contentLength<2000))response.sendRedirect("writePost.jsp");
	
	
	
	PostDao postDao = new PostDao();
	
	PostInfo postInfo = new PostInfo();
	postInfo.setCategoryId(Integer.parseInt(categoryId));
	postInfo.setWriter(writer);
	if(!StringUtils.equals(password, passwordConfirm))response.sendRedirect("writePost.jsp");
	postInfo.setPassword(password);
	postInfo.setTitle(title);
	postInfo.setPostContent(postContent);
	
	int insertReturn = postDao.insertPostInfo(postInfo);
	response.sendRedirect("viewPost.jsp?post="+insertReturn);
	
%>