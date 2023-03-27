<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
    <link
      href="https://fonts.googleapis.com/css?family=Poppins:400"
      rel="stylesheet"
    />
    <link href="https://webfontworld.github.io/goodchoice/Jalnan.css" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="/resources/testMainPage/css/bootstrap.min.css" />

    <!-- Custom stlylesheet -->
   
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
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
    
          <link rel="stylesheet" href="/resources/testMainPage/css/crescendo2.css" type="text/css">
     
          <style>
        #bookingtable{
            width: 350px;
            margin-top: 10px;
        }
      </style>
      
      <style type="text/css">
 		#button-class{
		  border: 0;
		  background-color: transparent;
		  font-size:15px;
		  color:white;
		  font-family: "Jalnan";
		}
	
 	</style>
    
  </head>

  <body>
  
    <div id="booking" class="section">
     <form action ="/logout" method="post">
      <div class="header">
        <h1><a href="/">거긴어때</a></h1>
        <div class="nav">
          <ul>
             <li><a href="/info">공지사항</a></li>
            <li><a href="/room">호텔정보</a></li>
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
               <li><span><button type="submit" class ="button-class">${sessionScope.loginAdmin.mem_Id}(관리자)님 로그아웃</button></span></li>
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
      <div class="rel_list">
      <h1 >예약 내역</h1>
      </div>
   <div class="rel_name">
   <span>${sessionScope.loginMember.mem_Id}님의 예약내역</span>
   </div>
   
   	 	<c:if test="${myPage == null}">
     		<div class = "text-center"><span>예약 내역이 없습니다.</span></div>
     	</c:if>
   
      <c:forEach items = "${myPage}" var ="dto">
     <section class=test13>
    
           <div id="container" class="cont">
        <div class="room">
        
            <a href="#"><div class="img-wrap">
                <img class="lazy" data-num="1" src="https:${dto.filepath}" id = "bookingtable" alt="${dto.filename}">
            </div></a>
            <div class="room-text">
                <div class="info-wrap">
                    <div class="amount-info">
                        <table class="table">
                            <span class="title">${dto.name}</span>
                            <thead>
                            <tr>
                                <th>예약 번호</th>
                                <th>객실 이름</th>
                                <th>호텔 주소</th>
                                <th>수용 인원</th>
                                <th>체크 인</th>
                                <th>체크 아웃</th>
                                <th>접수 날짜</th>
                                <th>결제 금액</th>
                               
                                
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${dto.booking_code}</td>
                                 <td>${dto.room_name}</td>
                                <td>${dto.hotel_detail_address}</td>
                                <td>${dto.room_member}</td>
                                <td><fmt:formatDate value="${dto.checkin}" pattern="yyyy-MM-dd"/></td>
                                <td><fmt:formatDate value="${dto.checkout}" pattern="yyyy-MM-dd"/></td>
                                <td><fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd"/></td>
                                <c:choose>
		                        <c:when test="${dto.days!=0}">
		                         <td>${dto.room_price} | ${dto.days} (박)</td>
		                         </c:when>
		                         <c:otherwise>
		                         <td>${dto.room_price} | (당일)</td>
		                         </c:otherwise>
		                        </c:choose>
		                                
                              
                            </tr>
                        </tbody>
                         </table>
                    </div>
                    
                       
                      
                    </div>
					<form action="/bookingCancel" method="post">
	                    <div class="info">
	                        <button style="width:150px; margin-left:900px;" class = "main_button">예약취소</button>
	                    </div>
	                    
	                    <input type = "hidden" name = "booking_check" value = "${dto.booking_code}">
                 	 </form>
                 	 
                 	 <form action="/refund" method="post">
	                    <div class="info">
	                        <button style="width:150px; margin-left:900px;" class = "main_button">카카오페이 예약취소</button>
	                    </div>
	                    
	                    <input type = "hidden" name ="booking_code" value = "${dto.booking_code}">
                 	 </form>
                 	 
                </div>

                
            </div>
           
        </div>
        </section>

        
       </c:forEach>
   
   
   
   

      </div>
    </div>
    </div>
  </body>
   <div style="padding-top:20%;">
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
</html>