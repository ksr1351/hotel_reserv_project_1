<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix= "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<link rel="shortcut icon" href="#">
    <title>Booking Form HTML Template</title>

 	<!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:400" rel="stylesheet" />
    <link href="https://webfontworld.github.io/goodchoice/Jalnan.css" rel="stylesheet" />

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="/resources/testMainPage/css/bootstrap.min.css" />

    <!-- Custom stlylesheet -->
	<script src="/resources/testMainPage/js/slider.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/raty/2.8.0/jquery.raty.min.js"></script>
    <style> 
    @import url('https://fonts.googleapis.com/css2?family=Gothic+A1:wght@700&family=Nanum+Pen+Script&display=swap');
    </style>
    <link type="text/css" rel="stylesheet" href="/resources/testMainPage/css/style.css" />
    <style type="text/css">
 		.button-class{
		  border: 0;
		  background-color: transparent;
		  font-size:15px;
		  color:white;
		}
 	</style>
 	
 	<script type="text/javascript">
//Raty 별점
$(document).ready(function() {
	var score = $(".rating").data("score");
    $(".rating").raty({
        readOnly: true,
        half: true,
        score: score,
        size: 25,
        path: 'https://cdnjs.cloudflare.com/ajax/libs/raty/2.8.0/images/'
    });
});
</script>
    
  </head>

  <body>
  
    <div id="booking" class="section">
     <form action ="/logout" method="post">
      <div class="header">
        <h1><a href="/">거긴어때</a></h1>
        <div class="nav">
          <ul>
          	<li><a href="/inform?currentPage=1">공지사항</a></li>
            <li><a href="/room">숙실정보</a></li>
            <li><a href="/check">예약내역</a></li>
            <li><a href="/board?currentPage=1">게시판</a></li>
        
           <c:choose>
            	<c:when test="${sessionScope.loginMember == null && sessionScope.loginKakao == null && sessionScope.loginAdmin==null}">
            		 <li><a href='/login'><span>로그인</span></a></li>
            		  <li><a href='/login'><span>회원가입</span></a></li>
            	</c:when>
            	<c:when test="${sessionScope.loginKakao != null}">
            		<li><a href="https://kauth.kakao.com/oauth/logout?client_id=fdb3ded4b5d753c2e685b7bb4ffbaa8d&logout_redirect_uri=http://localhost:8090/auth/kakao/logout">
            		<span>${sessionScope.loginKakao.mem_Id}님 로그아웃</span>
            		</a></li>
            		<li><a href='/'><span>내 정보</span></a></li>
            		<li><a href='/'><span>회원수정</span></a></li>
            	</c:when>
            	<c:when test="${sessionScope.loginAdmin != null}">
            	<li><span><button type="submit" class = "button-class">${sessionScope.loginAdmin.mem_Id}(관리자)님 로그아웃</button></span></li>
            	<li><a href='/management'><span>관리자 페이지</span></a></li>
            	</c:when>
            	<c:otherwise>
            		<li><span><button type="submit" class = "button-class">${sessionScope.loginMember.mem_Id}님 로그아웃</button></span></li>
            		<li><a href='/'><span>내 정보</span></a></li>
            		<li><a href='/'><span>회원수정</span></a></li>
            	</c:otherwise>
            	
            	
            </c:choose>
          </ul>
        </div>
      </div>
      </form>
	
	
     <div class="section-center">
        <div class="container">
          <div class="row">
            <section class="booking-form">
              <form action="/room">
                <div class="row no-margin">
                  <div class="col-md-3">
                    <div class="form-group">
                      <span class="form-label">Destination</span>
                      <input class="form-control" name="location" type="text" placeholder="Country, ZIP, city..." />
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="row no-margin">
                      <div class="col-md-5">
                        <div class="form-group">
                          <span class="form-label">Check In</span>
                          <input class="form-control" name ="checkin" type="date" required />
                        </div>
                      </div>
                      <div class="col-md-5">
                        <div class="form-group">
                          <span class="form-label">Check out</span>
                          <input class="form-control" name ="checkout" type="date" required />
                        </div>
                      </div>
                      <div class="col-md-2">
                        <div class="form-group">
                          <span class="form-label">Guests</span>
                          <select class="form-control">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                          </select>
                          <span class="select-arrow"></span>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <div class="form-btn">
                      <button class="submit-btn">Check availability</button>
                    </div>
                  </div>
                </div>
              </form>
            </section>
          </div>
		
		
    	<section>
			<h1 class="place-title">거긴 어때요?</h1>
			<div class="slide_wrapper">
				<ul class="slides">					
					<c:forEach items="${banner}" var="dto">
			        <li class='listbox'>
			          <a href='#'><img src="https:${dto.filepath}" alt="${dto.filename}" style="width: 300px" height=300px /></a>
			          <div class="overlay">
			            <div class='hotel-name'>${dto.name}</div>
			            <div class="rating" data-score="${dto.rating_avg}">${dto.rating_avg}</div>
			            <div class='address'>${dto.address}</div>
			          </div>
			        </li>
			      	</c:forEach>
				</ul>
			</div>

			<p class="controls">
              <span class="prev">prev</span>
              <span class="next">next</span>
            </p>
          </section>


         

          <div id="board_wrap">
			<div>
            <div class="board">
              <div class="title">
                <a href="#" class="name">게시판</a>
                <a href="/board?currentPage=1" class="more">더보기</a>
              </div>
              <div class="list">
               
                <c:forEach items = "${rawnumlist}" var = "dto">
                 <ul>
                  <li>
                    <a href="#">${dto.title} </a>
                    
                    <span>
                    <fmt:formatDate value="${dto.regdate}" pattern = "yyyy-MM-dd" />
                    </span>
                  </li>
                  </ul>
                  </c:forEach>
            
                
              </div>
            </div>
          </div>
        </div>
      </div>

      <footer>
        <p>
          거기어때컴퍼니는 통신판매중개자로서 통신판매의 당사자가 아니며, 상품의
          예약, 이용 및 환불 등과 관련한 의무와 책임은 각 판매자에게 있습니다.
        </p>
        <address>
          주소:서울특별시 강남구|대표이사:오이들|사업자등록번호:123-45-67894
        </address>
      </footer>
    </div>
    </div>
  </body>
</html>
