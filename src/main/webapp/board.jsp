<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.board.dto.PostSearchForm"%>
<%@page import="java.util.Optional"%>
<%@page import="com.board.dto.PageDto"%>
<%@page import="com.board.dto.PostViewDto"%>
<%@page import="java.io.IOException"%>
<%@page import="com.board.util.StringUtil"%>
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
int viewingPage = StringUtils.isEmpty(request.getParameter("page"))?1:Integer.parseInt(request.getParameter("page"));
//검색 form 양식
String fromDt = Optional.ofNullable(request.getParameter("fromDt")).orElse("");
String toDt =Optional.ofNullable(request.getParameter("toDt")).orElse("");
String categoryId = Optional.ofNullable(request.getParameter("category")).orElse("");
String searchMessage = Optional.ofNullable(request.getParameter("searchMessage")).orElse("");

PostSearchForm searchForm = PostSearchForm.builder()
						.fromDt(StringUtils.isEmpty(fromDt)?null:LocalDate.parse(fromDt, DateTimeFormatter.ISO_LOCAL_DATE))
						.toDt(StringUtils.isEmpty(toDt)?null:LocalDate.parse(toDt, DateTimeFormatter.ISO_LOCAL_DATE))
						.categoryId(categoryId)
						.searchMessage(searchMessage)
						.start(Integer.toString(viewingPage))
						.build();
PostDao postDao = new PostDao();
List<PostViewDto> postList = postDao.getPostViewList(searchForm);
int totalPostCount = postDao.getPostCount(searchForm);


CategoryDao categoryDao = new CategoryDao();
List<CategoryInfo> categoryList = categoryDao.getCategoryAll();

PageDto<PostViewDto> pageDto = new PageDto<>();
pageDto.setData(postList);
pageDto.setTotalCount(totalPostCount);
pageDto.setViewingPage(viewingPage);

//게시글 목록 그리는 메소드
StringUtil utils = new StringUtil();

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
.flex-container--align-right{
	display: flex;
	justify-content: flex-end;
}
</style>
<script src="https://kit.fontawesome.com/87e4ead53b.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<header>게시판 - 목록</header>
	<nav>
		<div>
			<form action="" method="get" id="searchForm">
				등록일 
				<input type="date" name="fromDt">
				<input type="date" name="toDt">
				<select name="category">
					<option value=""></option>
					<%
						for(CategoryInfo category : categoryList){
							String option = "<option value='";
							option += Integer.toString(category.getCategoryId());
							option += "' ";
							if(categoryId.equals(Integer.toString(category.getCategoryId()))){
								option += "selected";
							}
							
							option += ">"+category.getCategoryName();
							option += "</option>";
							out.print(option);
						}
					%>
				</select>
				<input type="text" name="searchMessage">
				<input type="hidden" name="page" id="pageInput">
				<button>검색</button>
			</form>
		</div>
	</nav>
	<main>
		<div><%=totalPostCount%></div>
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
				
				<%
					
					for(int i = 0;i<10;i++){
						if(i==postList.size())break;
						
						PostViewDto item = postList.get(i);
						
						String result = "<div class='board-container__row' onclick='location.href'>";
						result +=utils.createListItem(item.getCategoryName(), "category");
						result +=utils.createListItem(item.getFileCount()>0?"<i class='fa-solid fa-paperclip'></i>":"", "file");
						result +=utils.createListItem("<a href='viewPost.jsp?post="+item.getPostId()+"'>"+item.getTitle()+"</a>", "title");
						result +=utils.createListItem(item.getWriter(), "writer");
						result +=utils.createListItem(Integer.toString(item.getViewCount()), "count");
						result +=utils.createListItem(item.getWriteDt().toString(), "date");
						result +=utils.createListItem(item.getUpdateDt().toString(), "date");
						result +="</div>";
						out.print(result);
					}
				%>
			</div>
		</div>
		<div>
			<div class="page-nav">
				<a href='#' onclick="setPageInput(<%= 1 %>)">
					<i class="fa-solid fa-angles-left"></i>
				</a>
				<a href='#' onclick="setPageInput(<%= viewingPage>1?viewingPage-1:1 %>)">
					<i class="fa-solid fa-angle-left"></i>
				</a>
				<div class="page-nav__list">
					<%
						int totalPageNum = pageDto.getTotalPage();
						for(int i = 1;i<=totalPageNum;i++){
							if(i==viewingPage){
					%>	
								<b><%= i %></b>
					<%	
							}else{
					%>
								<a href='#' onclick="setPageInput(<%= i %>)"><%= i %></a>
					<%
							}
						}
					%>
				</div>
				<a href='#' onclick="setPageInput(<%= viewingPage<totalPageNum?viewingPage+1:totalPageNum %>)">
					<i class="fa-solid fa-angle-right"></i>
				</a>
				<a href='#' onclick="setPageInput(<%= totalPageNum %>)">
					<i class="fa-solid fa-angles-right"></i>
				</a>
			</div>
		</div>
		<div class="flex-container--align-right">
			<button>등록</button>
		</div>
	</main>
	<script type="text/javascript">
	function setPageInput(param){
		const pageInput = document.querySelector("#pageInput");
		pageInput.value = param;
		const form = document.querySelector("#searchForm");
		form.submit();
	}
	</script>
</body>
</html>