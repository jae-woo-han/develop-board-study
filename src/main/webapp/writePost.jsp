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
.form{
	margin: 5vh 10px;
}
.form__row{
	border-bottom: solid 1px black;
}
.form__row--top{
	border-top: solid 1px black;
}
.form__button{
	margin-top: 1vh;
}
.form__item{
	padding: 10px;
}
.form__label{
	background-color: lightgray;
	width: 15vw;
}
.form__input{
	margin-left: 30px;
}
</style>
</head>
<body>
	<header>게시글-등록</header>
	<main>
		<form action="insertPost.jsp" method="post" class="form">
			<div class="flex-container form__row form__row--top">
				<div class="form__item form__label">카테고리</div>
				<select name="category" class="form__item form__input">
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
			<div class="flex-container form__row">
				<div class="form__item form__label">작성자</div>
				<input class="form__item form__input" type="text" name="writer">
			</div>
			<div class="flex-container form__row">
				<div class="form__item form__label">비밀번호</div>
				<input class="form__item form__input" type="password" name="password" placeholder="비밀번호">
				<input class="form__item form__input" type="password" name="passwordConfirm" placeholder="비밀번호 확인">
			</div>
			<div class="flex-container form__row">
				<div class="form__item form__label">제목</div>
				<input class="form__item form__input" type="text" name="title">
			</div>
			<div class="flex-container form__row">
				<div class="form__item form__label">내용</div>
				<textarea class="form__item form__input" rows="20" cols="60" name="postContent"></textarea>
			</div>
			<div class="flex-container form__row">
				<div class="form__item form__label">파일 첨부</div>
			</div>
			<div class="flex-container flex-container--justify-between form__button">
				<input type="button" value="취소" onclick="cancelWrite(); return false">
				<input type="submit" value="저장">
			</div>
		</form>
	</main>
	
	<script type="text/javascript">
		function cancelWrite() {
			if(!confirm("게시판으로 돌아갑니다."))return false;
			location.href="board.jsp";
		}
	
	</script>
</body>
</html>