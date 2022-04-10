<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.board.domain.CategoryInfo"%>
<%@page import="com.board.dao.CategoryDao"%>
<%@page import="com.board.domain.PostInfo"%>
<%@page import="com.board.dao.PostDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//게시글 목록 페이지
//게시글 조회
PostDao postDao = new PostDao();
List<PostInfo> postList = postDao.getPostList();

CategoryDao categoryDao = new CategoryDao();
List<CategoryInfo> categoryList = categoryDao.getCategoryAll();

//페이지 이동
//게시글 등록


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>

<style type="text/css">
body {
	margin: 3vh;
}

.board-container {
	display: flex;
	flex-direction: column;
}

.board-container__row {
	display: flex;
	border-color: black;
	border-style: solid;
	border-width: 0 0 1px;
	justify-content: space-around;
	text-align: center;
}

.board-container__header {
	border-color: black;
	border-style: solid;
	border-width: 1px 0 2px;
}

.board-container__row-item--category {
	flex: 3
}

.board-container__row-item--file {
	flex: 1
}

.board-container__row-item--title {
	flex: 9
}

.board-container__row-item--writer {
	flex: 3
}

.board-container__row-item--count {
	flex: 2
}

.board-container__row-item--date {
	flex: 3
}

.page-nav {
	display: flex;
	justify-content: center;
}
</style>
<script src="https://kit.fontawesome.com/87e4ead53b.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<header>게시판 - 목록</header>
	<nav>
		<div>검색창</div>
	</nav>
	<main>
		<div><%=postList.size()%></div>
		<div>
			<div class="board-container">
				<div class="board-container__row board-container__header">
					<div class="board-container__row-item--category">카테고리</div>
					<div class="board-container__row-item--file"></div>
					<div class="board-container__row-item--title">제목</div>
					<div class="board-container__row-item--writer">작성자</div>
					<div class="board-container__row-item--count">조회수</div>
					<div class="board-container__row-item--date">등록일시</div>
					<div class="board-container__row-item--date">수정일시</div>
				</div>
				<div class="board-container__row">
					<div class="board-container__row-item--category">자바</div>
					<div class="board-container__row-item--file"></div>
					<div class="board-container__row-item--title">자바 공부해봐요</div>
					<div class="board-container__row-item--writer">한재우</div>
					<div class="board-container__row-item--count">75</div>
					<div class="board-container__row-item--date">2022.04.10 17:10</div>
					<div class="board-container__row-item--date">2022.04.10 17:11</div>
				</div>
				<div class="board-container__row">
					<div class="board-container__row-item--category">자바</div>
					<div class="board-container__row-item--file"></div>
					<div class="board-container__row-item--title">자바 공부해봐요</div>
					<div class="board-container__row-item--writer">한재우</div>
					<div class="board-container__row-item--count">75</div>
					<div class="board-container__row-item--date">2022.04.10 17:10</div>
					<div class="board-container__row-item--date">2022.04.10 17:11</div>
				</div>
				<div class="board-container__row">
					<div class="board-container__row-item--category">자바</div>
					<div class="board-container__row-item--file"></div>
					<div class="board-container__row-item--title">자바 공부해봐요</div>
					<div class="board-container__row-item--writer">한재우</div>
					<div class="board-container__row-item--count">75</div>
					<div class="board-container__row-item--date">2022.04.10 17:10</div>
					<div class="board-container__row-item--date">2022.04.10 17:11</div>
				</div>
				<div class="board-container__row">
					<div class="board-container__row-item--category">자바</div>
					<div class="board-container__row-item--file"></div>
					<div class="board-container__row-item--title">자바 공부해봐요</div>
					<div class="board-container__row-item--writer">한재우</div>
					<div class="board-container__row-item--count">75</div>
					<div class="board-container__row-item--date">2022.04.10 17:10</div>
					<div class="board-container__row-item--date">2022.04.10 17:11</div>
				</div>
				<div class="board-container__row">
					<div class="board-container__row-item--category">자바</div>
					<div class="board-container__row-item--file"></div>
					<div class="board-container__row-item--title">자바 공부해봐요</div>
					<div class="board-container__row-item--writer">한재우</div>
					<div class="board-container__row-item--count">75</div>
					<div class="board-container__row-item--date">2022.04.10 17:10</div>
					<div class="board-container__row-item--date">2022.04.10 17:11</div>
				</div>
				<div class="board-container__row">
					<div class="board-container__row-item--category">자바</div>
					<div class="board-container__row-item--file">
						<i class="fa-solid fa-paperclip"></i>
					</div>
					<div class="board-container__row-item--title">자바 공부해봐요</div>
					<div class="board-container__row-item--writer">한재우</div>
					<div class="board-container__row-item--count">75</div>
					<div class="board-container__row-item--date">2022.04.10 17:10</div>
					<div class="board-container__row-item--date">2022.04.10 17:11</div>
				</div>
				<div class="board-container__row">
					<div class="board-container__row-item--category">자바</div>
					<div class="board-container__row-item--file"></div>
					<div class="board-container__row-item--title">자바 공부해봐요</div>
					<div class="board-container__row-item--writer">한재우</div>
					<div class="board-container__row-item--count">75</div>
					<div class="board-container__row-item--date">2022.04.10 17:10</div>
					<div class="board-container__row-item--date">2022.04.10 17:11</div>
				</div>

			</div>
		</div>
		<div>
			<div class="page-nav">
				<button>
					<i class="fa-solid fa-angles-left"></i>
				</button>
				<button>
					<i class="fa-solid fa-angle-left"></i>
				</button>
				<div class="page-nav__list">1 2 3 4</div>
				<button>
					<i class="fa-solid fa-angles-right"></i>
				</button>
				<button>
					<i class="fa-solid fa-angle-right"></i>
				</button>
			</div>
		</div>
		<div>버튼</div>
	</main>
</body>
</html>