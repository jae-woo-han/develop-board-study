<%@page import="com.board.domain.CategoryInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.board.dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

CategoryDao categoryDao = new CategoryDao();
List<CategoryInfo> categoryList = categoryDao.getCategoryAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<style type="text/css">
.flex-container{
	display: flex;
}
.flex-container--justify-between{
	justify-content: space-between;
}
</style>
</head>
<body>
	<header>게시글-등록</header>
	<main>
		<form action="">
			<div class="flex-container ">
				<div>카테고리</div>
				<select name="category">
					<option value="카테고리 선택">카테고리 선택</option>
					<%
						for(CategoryInfo category : categoryList){
							String option = "<option value='";
							option += Integer.toString(category.getCategoryId());
							option += "' ";
							option += ">"+category.getCategoryName();
							option += "</option>";
							out.print(option);
						}
					%>
				</select>
			</div>
			<div class="flex-container">
				<div>작성자</div>
			</div>
			<div class="flex-container">
				<div>비밀번호</div>
			</div>
			<div class="flex-container">
				<div>제목</div>
			</div>
			<div class="flex-container">
				<div>내용</div>
			</div>
			<div class="flex-container">
				<div>파일 첨부</div>
			</div>
			<div class="flex-container flex-container--justify-between">
				<input type="button" value="취소">
				<input type="button" value="저장">
			</div>
		</form>
	</main>
</body>
</html>