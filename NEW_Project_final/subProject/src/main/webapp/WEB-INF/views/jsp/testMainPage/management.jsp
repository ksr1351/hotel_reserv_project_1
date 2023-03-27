<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src='/resources/testMainPage/admin/js/manager.js'></script>
   <link rel="stylesheet" href="/resources/testMainPage/admin/css/reservation.css">
  <link rel="stylesheet" href="/resources/testMainPage/admin/css/manager.css" type="text/css">
  
    <title>거기어떄 관리자페이지</title>
   <!--  <link rel="stylesheet" href="admin-style.css" /> -->
  </head>
  <body>
    <header id="inlineFrame"
    title="Inline Frame Example"
    width ="100%"
    height ="800">
    
    <nav>
      <ul>
        <li><a href="/" data-url="/" class="link"><strong>HOME</strong></a></li>
        <li><a href="/management" data-url="/reservation" class="link"><strong>예약관리</strong></a></li>
        <li><a href="#" data-url="/announcement.html" class="link"><strong>공지사항</strong></a></li>
      </ul>
    </nav>
      <h1>거기어때 관리자</h1>
      
    </header>
    
     <div style="padding-top:10%;">
     <div class="board_list_wrap">
            <table class="board_list">
                <h1>예약자 목록</h1>
                <!-- <a href="../게시판/notice_board.html"> -->
                  
                <button class="write-btn">관리자 수정</button>
                </a>
                <thead>
                    <tr>
                    	<th>예약번호</th>
                        <th>호텔 이름</th>
                        <th>객실 이름</th>
                        <th>핸드폰번호</th>
                        <th>예약자 성함</th>
                        <th>접수한 날짜</th>
                        <th>예약 날짜</th>
                        <th>퇴실 날짜</th>
                        <th>예약 취소 날짜</th>
                        <th>결제 금액</th>
                    </tr>
                </thead>
                <tbody>
               <c:forEach items = "${manageList}" var = "dto">
                
                    <tr>
                        <td>${dto.booking_code}</td>
                        <td class="tit">
                            <a href="#">${dto.name}</a>
                        </td>
                        <td>${dto.room_name}</td>
                        <td>${dto.mem_Phone}</td>
                        <td>${dto.mem_Name}</td>
                        <td><fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${dto.checkin}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${dto.checkout}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${dto.canceldate}" pattern="yyyy-MM-dd"/></td>
                        
                        <c:choose>
                        <c:when test="${dto.days!=0}">
                         <td>${dto.room_price} | ${dto.days} (박)</td>
                         </c:when>
                         <c:otherwise>
                         <td>${dto.room_price} | (당일)</td>
                         </c:otherwise>
                        </c:choose>
                       
                  
                    </tr>
                  </c:forEach>   
               
                </tbody>
            </table>
            <div class="paging">
                <a href="#" class="bt">첫 페이지</a>
                <a href="#" class="num on">1</a>
                <a href="#" class="num">2</a>
                <a href="#" class="num">3</a>
                <a href="#" class="bt">마지막 페이지</a>
            </div>
        </div>
   </div>
      <!-- <h2>Welcome to the Admin Dashboard</h2>
      <p>Here you can manage all aspects of your website.</p> -->
     
     
   

    
    
    <footer>
      <p>&copy; 2023 My 오이들</p>
    </footer>
    <!-- <script src="admin-script.js"></script> -->
  </body>
</html>