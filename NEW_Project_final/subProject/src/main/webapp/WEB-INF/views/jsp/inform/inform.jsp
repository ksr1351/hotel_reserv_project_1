<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<link rel="shortcut icon" href="#">
<title>inform</title>
<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Poppins:400" rel="stylesheet" />
<link href="https://webfontworld.github.io/goodchoice/Jalnan.css" rel="stylesheet">
<!-- Bootstrap -->
<!-- <link type="text/css" rel="stylesheet"
	href="/resources/testMainPage/css/bootstrap.min.css" /> -->
<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="/resources/testMainPage/css/style.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/testMainPage/css/announcement.css" type="text/css">

<style type="text/css">
.button-class {
	border: 0;
	background-color: transparent;
	font-size: 15px;
	color: white;
	font-family: "Jalnan";
}
</style>
</head>

<body>

	<div id="booking" class="section">
		<form action="/logout" method="post">
			<div class="header">
				<h1>
					<a href="/">거긴어때</a>
				</h1>
				<div class="nav">
					<ul>
						<li><a href="/inform?currentPage=1">공지사항</a></li>
						<li><a href="/room">숙실정보</a></li>
						<li><a href="/check">예약내역</a></li>
						<li><a href="/board?currentPage=1">게시판</a></li>

						<c:choose>
							<c:when test="${sessionScope.loginMember == null}">
								<li><a href='/login'><span>로그인</span></a></li>
								<li><a href='/login'><span>회원가입</span></a></li>
							</c:when>
							<c:otherwise>
								<li><span><button type="submit" class="button-class">${sessionScope.loginMember.mem_Id}님
											로그아웃</button></span></li>
								<li><a href='/'><span>내 정보</span></a></li>
								<li><a href='/'><span>회원수정</span></a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</form>






		<div class="board_list_wrap">
			<table class="board_list">
				<h1>공지사항</h1>

				<a href="inform/write" class="btn-wrap">
					<button class="write-btn">글쓰기</button>
				</a>
				
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>


					<c:forEach items="${list}" var="inform">
						<tr>
							<td>${inform.notice_code}</td>
							<td><a href="/noticeReadView?notice_code=${inform.notice_code}">${inform.title}</a></td>
							<td>${inform.admin_id}</td>
							<td><fmt:formatDate value="${inform.regdate}"
									pattern="yyyy-MM-dd" /></td>
							<td>${inform.readcount}</td>
						</tr>
					</c:forEach>
				</thead>
				<tbody>
					<tr>

					</tr>
				</tbody>
			</table>

			<!--  드롭창 시작 -->
			<div id = "board-search">
			<div class = "container">
			<div class = "search-window">
			<form action="/inform" method="get" name="search-form">
				<div class="search-wrap">
					<select class="form-control search-select" name="searchKey"
						onchange="getSearchList()">
						<option value="title"
							${pv.searchKey eq 'title' ? 'selected' : '' }>제목</option>
						<option value="content"
							${pv.searchKey eq 'content' ? 'selected' : '' }>내용</option>
					</select>
					<!-- 드롭창 종료 -->

					<!-- 검색창 시작 -->
					<input type="text" class="form-control search-input"
						name="searchWord" value="${searchWord}">

					<button type="submit" class="btn btn-info search-btn">검색</button>
					
				</div>

				<input type="hidden" name="currentPage" value="1"> <input
					type="hidden" name="totalCount" value="10">
			</form>
			</div>
			</div>
			</div>
			
			<!-- 검색창 종료 -->
			

			<!-- 페이지 만들기 -->
			<div class="paging">
				<ul class="pagination justify-content-center mt-5 mb-5">
					<!-- style.css상단에 bootstrap적용해둠 -->



					<!-- prev(이전페이지) 출력 시작 -->
					<c:if test="${pv.startPage > 1}">
						<a class="bt prev" href="inform?currentPage=${pv.startPage - pv.blockPage}">Prev</a>
					</c:if>
					<!-- prev(이전페이지) 출력 끝-->



					<!-- 페이지 출력 시작 -->
					<c:forEach var="i" begin="${pv.startPage}" end="${pv.endPage}">
						<c:choose>
							<c:when test="${i==pv.currentPage}">

								<a class="num on" href="inform?currentPage=${i}&searchKey=${pv.searchKey}&searchWord=${pv.searchWord}&totalCount=${pv.totalCount}">${i}</a>
							</c:when>
							<c:otherwise>
								<a class="num" href="inform?currentPage=${i}&searchKey=${pv.searchKey}&searchWord=${pv.searchWord}&totalCount=${pv.totalCount}">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>


					<!-- next(다음페이지) 출력 시작 -->

					<c:if test="${pv.endPage < pv.totalPage}">
						<a class="bt" href="inform?currentPage=${pv.startPage + pv.blockPage}">Next</a>

					</c:if>
					<!-- next(다음페이지) 출력 끝 -->

					<!-- </ul> -->

				</ul>

			</div>

		</div>
</body>
<div style="padding-top: 5%">
	<footer>
		<p>거기어때컴퍼니는 통신판매중개자로서 통신판매의 당사자가 아니며, 상품의 예약, 이용 및 환불 등과 관련한 의무와
			책임은 각 판매자에게 있습니다.</p>
		<address>주소:서울특별시 강남구|대표이사:오이들|사업자등록번호:123-45-67894</address>
	</footer>
</div>
</html>