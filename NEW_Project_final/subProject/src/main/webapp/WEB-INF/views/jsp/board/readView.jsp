<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>Insert title here</title>

<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Poppins:400"
   rel="stylesheet" />
<link href="https://webfontworld.github.io/goodchoice/Jalnan.css"
   rel="stylesheet" />

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet"
   href="/resources/testMainPage/css/bootstrap.min.css" />

<!-- Custom stlylesheet -->
<!-- <link type="text/css" rel="stylesheet"
   href="/resources/testMainPage/css/style.css" />
 -->
<meta name="viewport" content="width=device-width, initial-scale=1" />

<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet" href="resources/board/board.css" />

<link type="text/css" rel="stylesheet"
   href="/resources/testMainPage/css/style.css" />

<link type="text/css" rel="stylesheet"
   href="/resources/testMainPage/cssBoard/style.css">


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
         formObj.attr("action", "/updateView");
         formObj.attr("method", "get");
         formObj.submit();
      });

      //삭제
      $(".delete_btn").on("click", function() {
         var deleteYN = confirm("삭제하시겠습니까?");
         if (deleteYN == true) {

            formObj.attr("action", "/delete");
            formObj.attr("method", "post");
            formObj.submit();
         }

      });

      // 댓글 작성
      $(".replyWriteBtn").on("click", function() {
         var formObj = $("form[name='replyForm']");
         formObj.attr("action", "/replyWrite");
         formObj.attr("method", "post");
         formObj.submit();

      });
   });
   
   // 댓글 수정 event
   function updateReply(code){
      $.ajax({
         type: "post",
         url: "/replyUpdate",
         data: 
         {"content" : $("#content"+code).val(),//textarea 고유값
            "reply_code": code},
            
         success: function(res){
            //댓글 수정 후 댓글 목록 갱신
            if(res>0){
               alert("수정에 성공하였습니다.");
               location.reload(); //새로고침
            }else{
               alert("수정에 실패하였습니다.");
            }
         },
         error: function(e){
            console.log(e.responseText);
         }
      });
   }
   
   // 댓글 삭제 event
   function deleteReply(code){
      

      var deleteYN = confirm("댓글을 삭제하시겠습니까?");
      if (deleteYN == true) {

         $.ajax({
            url : "/replyDelete",
            type : "post",
            dataType : "json",
            data : {
               "reply_code" : code
            },
            success : function(res) {
               if (res == 1) {
                  //삭제에 성공했을 때 
                  alert("삭제에 성공하였습니다.");
                  location.reload(); //페이지 새로고침
               } else {
                  alert("삭제에 실패하였습니다.")
               }

            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
               alert("통신 실패")
            }

         });
      }
      
   }
   
   // 수정취소 event
   function cancleUpdateReply(code){

      var html = "";
      
      html += "<button class='replyUpdateBtn' onclick=updateForm("+code+")  data-reply_code="+code+">댓글 수정</button>";
      html += "<button class='replyDeleteBtn' onclick=deleteReply("+code+") data-reply_code="+code+">댓글 삭제</button>";
      
      $("#content"+code).css("display","none");
      $("#pcontent"+code).css("display","");
      $("#div"+code).html(html);
   }
   
   
   // 댓글 수정 Form
   
   function updateForm(code){
      var replyCode = code;
      var html = "";
      
      // jquery css이벤트로 display none을 해제시켜줌
      $("#content"+code).css("display","");
      
      $.ajax({
         type: "post",
         url: "/getReplyData",
         data:{"reply_code": code},
         success: function(res){
            $("#pcontent"+code).css("display","none");
            $("#content"+code).html(res.CONTENT);
            // 수정버튼을 눌렀으니, 수정완료랑 댓글삭제버튼을 새로 그려줌
            html += "<button onclick='updateReply("+replyCode+");'>수정 완료</button>";
            html += "<button onclick='cancleUpdateReply("+replyCode+");'>수정 취소</button>";
            
            // 버튼이 들어가있는 div 영역 삭제
            $("#li"+replyCode).children("div").remove();
            // div를 다시 그려줌
            $("#li"+replyCode).append("<div id='div"+replyCode+"'>"+html+"</div>");
            
         },
         error: function(e){
            console.log(e.responseText);
         }
      });
      
      
   }

</script>



<body>
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

   <!-- 게시글 상세보기-->

   <!-- 게시글 -->
   <section id="container" class='container'>
      <div class="readView_detail_wrap">

         <form name="readForm" role="form">
            <input type="hidden" id="board_code" name="board_code"
               value="${read.board_code}" />

            <table class="readView_detail">
               <tbody>
                  <tr>
                     <td><label class='borad_num' for="board_code">글 번호 . </label> <input
                        class='board_box1' type="text" id="board_code" name="board_code"
                        value="${read.board_code}" /></td>
                  </tr>
                  <tr class='test1'>
                     <td><label class='title1' for="title"  >제목</label> <input
                        class='test2' type="text" id="title" name="title" readonly
                        value="${read.title}" /></td>
                  </tr>
                  <tr>
                     <td><label for="content" class='content1'>내용</label><br>
                        <textarea id="content3" name="content" readonly><c:out
                              value="${read.content}" /></textarea></td>
                  </tr>
                  <tr>
                     <td><label id='font5' for="customer_code">작성자</label> <input
                        class='data_box' type="text" id="customer_code"
                        name="customer_code" value="${read.customer_code}" /></td>
                  </tr>
                  <tr>
                     <td><label for="regdate" id='font5'>작성날짜</label> <fmt:formatDate
                           value="${read.regdate}" pattern="yyyy-MM-dd" /></td>
                  </tr>

                  <tr>

                     <td id='font5'>첨부파일</td>

                     <td><c:if test="${!empty read.upload}">
                           <a class='data10'
                              href="contentdownload?board_code=${read.board_code}">
                              ${fn:substringAfter(read.upload,"_")}</a>

                        </c:if> 
                        <div class='data10'><c:if test="${empty read.upload}"><c:out  value="첨부파일 없음" />

                        </c:if></div>
                      </td>

                  </tr>

               </tbody>
            </table>
         </form>

         <div class='button1'>
            <button type="submit" class="update_btn">수정</button>
            <button type="submit" class="delete_btn">삭제</button>
            <a class="btn1" href="/board?currentPage=1">목록</a>
         </div>
      </div>

   </section>



   <!-- 댓글 -->

   <!-- 댓글 조회 -->
   <section class='container1'>
      <div id="reply">
         <ol class="replyList">
         	
            <c:forEach items="${replyList}" var="replyList">
               <li id="li${replyList.reply_code}">
                  <p id='font5'>
                     작성자 : ${replyList.customer_code}<br /> 작성 날짜 :
                     <fmt:formatDate value="${replyList.regdate}" pattern="yyyy-MM-dd" />
                  </p>
                  <p id="pcontent${replyList.reply_code}">${replyList.content}</p> <textarea
                     style="display: none;" id="content${replyList.reply_code}"
                     name="reply_content" rows="3">${reply.reply_content}</textarea>


                  <div class='reply2'>
                     <button type="submit" class="replyUpdateBtn"
                        onclick="updateForm(${replyList.reply_code})"
                        data-reply_code="${replyList.reply_code}">댓글 수정</button>
                     <button type="submit" class="replyDeleteBtn"
                        onclick="deleteReply(${replyList.reply_code})"
                        data-reply_code="${replyList.reply_code}">댓글 삭제</button>
                  </div>

               </li>
            </c:forEach>
         </ol>
      </div>

      <!-- 댓글 작성 -->
      <form class='replyList1' name="replyForm">
         <input type="hidden" id="board_code" name="board_code"
            value="${read.board_code}" />


         <div>
            <lable id='font5' for="customer_code">댓글 작성자</lable>
            <input class='name5' type="text" id="customer_code"
               name="customer_code" /> <br />
            <lable id='font5' for="content">댓글 내용</lable>
            <br> <input class='re_text' type="text" id="content"
               name="content" />
         </div>
         <div>
            <button type="submit" class="replyWriteBtn">작성</button>
         </div>
      </form>
      </div>
   </section>
   
    <li class="banner"><a href=""> <img
         src="/resources/img/KakaoTalk_20230321_145013464.jpg"
         style="width: 200px; height: 200px" /> <img
         src="/resources/img/KakaoTalk_20230321_145013560.jpg"
         style="width: 200px; height: 200px" /> <img
         src="/resources/img/KakaoTalk_20230321_145013671.jpg"
         style="width: 200px; height: 200px" />
   </a><span class="text9">초특가</span></li>

</body>
<div style="padding-top: 5%;">
   <footer>
      <p>거기어때컴퍼니는 통신판매중개자로서 통신판매의 당사자가 아니며, 상품의 예약, 이용 및 환불 등과 관련한 의무와
         책임은 각 판매자에게 있습니다.</p>
      <address>주소:서울특별시 강남구|대표이사:오이들|사업자등록번호:123-45-67894</address>
   </footer>
</div>
</html>