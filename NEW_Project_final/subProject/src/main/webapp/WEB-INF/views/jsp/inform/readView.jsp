
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<link rel="shortcut icon" href="#">
<title>readView</title>

<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Poppins:400"
	rel="stylesheet" />
<link href="https://webfontworld.github.io/goodchoice/Jalnan.css"
	rel="stylesheet">
<!-- Bootstrap -->
<link type="text/css" rel="stylesheet"
	href="/resources/testMainPage/css/bootstrap.min.css" />
<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet"
	href="/resources/testMainPage/css/style.css" />
<link rel="stylesheet"
	href="resources/testMainPage/css/announcement.css" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
<style type="text/css">
.button-class {
	border: 0;
	background-color: transparent;
	font-size: 15px;
}
</style>
	
</head>
<script type="text/javascript">
	var changeFlag = "";

	$(document).ready(function() {
		var formObj = $("form[name='readForm']");

		//수정
		$(".update_btn").on("click", function() {
			formObj.attr("action", "/noticeUpdateView");
			formObj.attr("method", "get");
			formObj.submit();
		});

		//삭제
		$(".delete_btn").on("click", function() {
			var deleteYN = confirm("삭제하시겠습니까?");
			if (deleteYN == true) {

				formObj.attr("action", "/noticeDelete");
				formObj.attr("method", "post");
				formObj.submit();
			}

		});

		//취소(목록으로 돌아가기)
/* 		$(".list_btn").on("click", function() {
			formObj.attr("action", "/inform?currentPage=1");
			formObj.submit();
		});  */
		
	});
</script>

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

		<div class="container test">
			<h2>공지사항 조회</h2>
			<!-- <form action="/write" method="post" enctype="multipart/form-data"> -->
			<form name="readForm" role="form">
			<input type="hidden" id="notice_code" name="notice_code" value="${read.notice_code}" />
				
				<div class="form-group">
					<label for="notice_code">글번호</label> </br> 
					<input type="text"
						class="form-control" id="notice_code"
						name="notice_code" value="${read.notice_code}">
				</div>

				<div class="form-group">
					<label for="title">제목</label>
					<!-- placeholder 속성 입력한 데이터가 없는 경우 배경으로 나타난다.실제적으로 입력을 100자까지로 지정 -->
					<!-- required 속성을 설정하면 필수입력 사항이된다. -->
					<!-- pattern 속성을 이용한 정규표현식으로 데이터의 유효성 검사를 할 수 있다. -->
					<input type="text" class="form-control" id="title"
				        name="title" maxlength="100"
						required="required" pattern=".{4,100}" value="${read.title}">
				</div>

				<div class="form-group">
					<label for="admin_id">작성자</label> <input type="text"
						class="form-control" id="admin_id"
						name="admin_id" value="${read.admin_id}">
				</div>

				<div class="form-group">
					<label for="content">내용</label>
					<!--  여러줄의 데이터를 입력하고 하고자 할때 textarea 태그를 사용한다. -->
					<!--  textarea 안에 있는 모든 글자는 그대로 나타난다. 공백문자, tag, enter -->
					<textarea class="form-control" rows="5" id="content" name="content"><c:out value="${read.content}" /></textarea>
				</div>
				
				<div class="form-group">
					<label for="regdate">작성날짜</label></br> 
					<fmt:formatDate value="${read.regdate}" pattern="yyyy-MM-dd" />
				</div>
				
				<div class="form-group">
				<label for="upload">첨부파일</label></br> 
						<td><c:if test="${!empty read.upload}">
								<a class='data10'
									href="noticeContentdownload?notice_code=${read.notice_code}">
									${fn:substringAfter(read.upload,"_")}</a>
									
								</c:if> <c:if test="${empty read.upload}">
								<c:out value="첨부파일 없음" /></c:if>
							</td>
					</div> 
					</br>
				
				<button type="submit" class="update_btn">수정</button>
				<button type="submit" class="delete_btn">삭제</button>
				<a class="btn btn-default" href="/inform?currentPage=1">목록</a>

			</form>
		</div>
	</div>
</body>

<div style="padding-top: 5%;">
	<footer>
		<p>거기어때컴퍼니는 통신판매중개자로서 통신판매의 당사자가 아니며, 상품의 예약, 이용 및 환불 등과 관련한 의무와
			책임은 각 판매자에게 있습니다.</p>
		<address>주소:서울특별시 강남구|대표이사:오이들|사업자등록번호:123-45-67894</address>
	</footer>
</div>
</html>