$(function() {
   $('#btnWrap button').on('click', function() {
       $('#btnWrap button').removeClass('on');
       $(this).addClass('on');
       $('.cont').addClass('hide');
       const targetId = $(this).data('id');
       $(`#${targetId}`).removeClass('hide');

       // Load review list when the 'review' tab is clicked
       if (targetId === 'review') {
         loadReviewList(hotel_code);
       }
   });
});

$(function() {
  $('.detail_info .category').each(function(e){ // 숙소정보 열기
    $(this).click(function(i){
        i.preventDefault();
        if ($(this).hasClass('on')){
            $('.detail_info .category').removeClass('on');
            $('.detail_info section').hide();
        }else{
            $('.detail_info .category').removeClass('on');
            $('.detail_info section').hide();
            $(this).addClass('on');
            $(this).next('section').show();
        }

    });
});
})


$(function() {
	
	const slideShows = document.querySelectorAll('.slideShow');
		
	slideShows.forEach((slideShow)=>{
	
	const slideId = slideShow.dataset.id;
    const slides = slideShow.querySelector('.slides'); //전체 슬라이드 컨테이너
	const slideImg = slideShow.querySelectorAll('.slides li'); //모든 슬라이드들
	let currentIdx = 0; //현재 슬라이드 index
	const slideCount = slideImg.length; // 슬라이드 개수
	const prev = slideShow.querySelectorAll('.prev'); //이전 버튼
	const next = slideShow.querySelectorAll('.next'); //다음 버튼
	
	
	const slideWidth = 490; //한개의 슬라이드 넓이
	const slideMargin = 10; //슬라이드간의 margin 값

	//전체 슬라이드 컨테이너 넓이 설정
	slides.style.width = (slideWidth + slideMargin) * slideCount + 'px';
	
	function moveSlide(ulPath, num) {
	  ulPath.style.left = -num * 500 + 'px';
	  currentIdx = num;
	}

	$(prev).on('click', function () {
	  /*첫 번째 슬라이드로 표시 됐을때는 
	  이전 버튼 눌러도 아무런 반응 없게 하기 위해 
	  currentIdx !==0일때만 moveSlide 함수 불러옴 */
	
		let ulPath = $(this).parent().parent().children()[0];
	
	  if (currentIdx !== 0) moveSlide(ulPath, currentIdx - 1);
	});
	
	
    	 
	$(next).on('click', function () {
	  /* 마지막 슬라이드로 표시 됐을때는 
	  다음 버튼 눌러도 아무런 반응 없게 하기 위해
	  currentIdx !==slideCount - 1 일때만 
	  moveSlide 함수 불러옴 */
	  
	  //alert($(this)[0].nodeName);
	  
	  let ulPath = $(this).parent().parent().children()[0];
	  
	 //alert($(this).parent().parent().children()[0]);
	  
	 if (currentIdx<5) {
	    moveSlide(ulPath, currentIdx + 1);
	  }
	  
   });

 });
	
});
	


$(function() {
  $('.lazy').on('click', function() {
    $('.slideShow.'+$(this).data('num')).toggleClass('hide');
  })
})


