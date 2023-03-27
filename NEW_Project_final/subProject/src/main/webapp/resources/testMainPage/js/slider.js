window.onload = function() {
  // 슬라이드 요소 선택
  var slides = document.querySelector(".slides"),
    slide = document.querySelectorAll(".slides li"),
    currentIdx = 0,
    slideCount = slide.length,
    prevBtn = document.querySelector(".prev"),
    slideWidth = 300,
    slideMargin = 30,
    nextBtn = document.querySelector(".next");

  slides.style.width = (slideWidth + slideMargin) * slideCount - slideMargin + "px";

  // 슬라이드 이동 함수
  function moveSlide(num) {
    //slides.style.left = -num * 330 + "px";
    slides.style.transform = 'translateX(' + (-num * 330) + 'px)';
    currentIdx = num;
  }

  // 자동 슬라이드 함수
  function autoSlide() {
    if (currentIdx < slideCount - 3) {
      moveSlide(currentIdx + 1);
    } else {
      moveSlide(0);
    }
  }

  // 자동 슬라이드 시작
  var slideId = setInterval(autoSlide, 3000);

  // 이전 버튼 클릭 이벤트 핸들러
  prevBtn.addEventListener("click", function() {
    if (currentIdx > 0) {
      moveSlide(currentIdx - 1);
    } else {
      moveSlide(slideCount - 3);
    }
  });

  // 다음 버튼 클릭 이벤트 핸들러
  nextBtn.addEventListener("click", function() {
    if (currentIdx < slideCount - 3) {
      moveSlide(currentIdx + 1);
    } else {
      moveSlide(0);
    }
  });

  // 슬라이드 영역에 마우스 올릴 때 자동 슬라이드 멈춤
  slides.addEventListener("mouseenter", function() {
    clearInterval(slideId);
  });

  // 슬라이드 영역에서 마우스 떠날 때 자동 슬라이드 재시작
  slides.addEventListener("mouseleave", function() {
    slideId = setInterval(autoSlide, 3000);
  });
};