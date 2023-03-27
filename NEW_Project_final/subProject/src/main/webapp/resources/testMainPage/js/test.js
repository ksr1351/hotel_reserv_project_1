$(function() {
	
	const slideShows = document.querySelectorAll('.slideShow');
		
	slideShows.forEach((slideShow)=>{
	
	const slideId = slideShow.dataset.id;
    const slides = document.querySelector('.slides'); //전체 슬라이드 컨테이너
	const slideImg = document.querySelectorAll('.slides li'); //모든 슬라이드들
	let currentIdx = 0; //현재 슬라이드 index
	const slideCount = slideImg.length; // 슬라이드 개수
	const prev = document.querySelector('.prev [data-id="${slideId}"]'); //이전 버튼
	const next = document.querySelector('.next [data-id="${slideId}"]'); //다음 버튼
	const slideWidth = 490; //한개의 슬라이드 넓이
	const slideMargin = 10; //슬라이드간의 margin 값

	//전체 슬라이드 컨테이너 넓이 설정
	slides.style.width = (slideWidth + slideMargin) * slideCount + 'px';
	
	function moveSlide(num) {
	  slides.style.left = -num * 500 + 'px';
	  currentIdx = num;
	}

	prev.addEventListener('click', function () {
	  /*첫 번째 슬라이드로 표시 됐을때는 
	  이전 버튼 눌러도 아무런 반응 없게 하기 위해 
	  currentIdx !==0일때만 moveSlide 함수 불러옴 */
	
	  if (currentIdx !== 0) moveSlide(currentIdx - 1);
	});
	
	next.addEventListener('click', function () {
	  /* 마지막 슬라이드로 표시 됐을때는 
	  다음 버튼 눌러도 아무런 반응 없게 하기 위해
	  currentIdx !==slideCount - 1 일때만 
	  moveSlide 함수 불러옴 */
	  if (currentIdx<5) {
	    moveSlide(currentIdx + 1);
	  }
	  
   });

 });
	
});
	


$(function() {
  $('.lazy').on('click', function() {
    $('.slideShow.'+$(this).data('num')).toggleClass('hide');
  })
})