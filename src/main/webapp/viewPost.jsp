<%@page import="com.board.dto.PostViewDto"%>
<%@page import="com.board.dao.PostDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String postId = request.getParameter("post");
	PostDao postDao = new PostDao();
	PostViewDto postView = postDao.getPostView(postId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<style type="text/css">
main{
	width: 96vw;
}
.flex-container{
	display: flex;
}
.flex-container--justify-between{
	justify-content: space-between;
}
.flex-container--justify-center{
	justify-content: center;
}
.flex-container__item{
	margin:0 10px;
}
.flex-container__item--grow-6{
	flex-grow: 6;
}
.article{
	border: solid 1px black;
	padding: 3px;
	margin:0 10px;
}

</style>
</head>
<body>
	<header>게시글</header>
	<main>
		<div class="flex-container flex-container--justify-between">
			<span class="flex-container__item flex-container__item--grow-6"><%=postView.getWriter() %></span>
			<span class="flex-container__item">등록일시 <%=postView.getWriteDt() %></span>
			<span class="flex-container__item">수정일시 <%=postView.getUpdateDt() %></span>
		</div>
		<div class="flex-container flex-container--justify-between">
			<span class="flex-container__item">[<%=postView.getCategoryName()%>]</span>
			<span class="flex-container__item flex-container__item--grow-6"><%=postView.getTitle()%></span>
			<span class="flex-container__item">조회수 <%=postView.getViewCount() %></span>
		</div>
		<hr>
		<article class="article">
			<%=postView.getPostContent() %>
		</article>
		<div>
			파일
		</div>
		<div>
			댓글
		</div>
	</main>
	<footer class="flex-container flex-container--justify-center">
		<a href="board.jsp">목록</a>
		<a href="updatePost.jsp?post=<%=postView.getPostId()%>">수정</a>
		<a href="deletePost.jsp?post=<%=postView.getPostId()%>">삭제</a>
	</footer>
	
</body>
</html>