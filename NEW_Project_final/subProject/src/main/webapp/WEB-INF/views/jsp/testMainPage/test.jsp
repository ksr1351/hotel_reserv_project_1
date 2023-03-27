<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="/resources/testMainPage/css/bootstrap.min.css" />

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="/resources/testMainPage/css/style.css" />
  </head>

  <body>
    <div id="booking" class="section">
      <div class="header">
        <h1><a href="/">거긴어때</a></h1>
        <div class="nav">
          <ul>
            <li><a href="/room">호텔정보</a></li>
            <li><a href="check">예약내역</a></li>
            <li><a href="/board">게시판</a></li>
            <li>
              <a href="/login"><span>로그인</span></a>
            </li>
          </ul>
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
  </body>
</html>