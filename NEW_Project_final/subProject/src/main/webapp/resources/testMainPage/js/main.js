$(document).ready(function () {
  $(".slider").bxSlider();

  $(".control_slider").bxSlider({
    //controls: false
    nextText: '<i class="fa-solid fa-chevron-right"></i>',
    prevText: '<i class="fa-solid fa-chevron-left"></i>',
    pager: false,
  });
});
