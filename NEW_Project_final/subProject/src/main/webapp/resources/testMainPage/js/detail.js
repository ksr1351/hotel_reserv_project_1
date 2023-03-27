
var hotel_code = $('#hotel_code').val();

function loadReviewList(hotel_code) {
	clearForm("reviewFrm");
	
	$.ajax({
	    url: "/getReviews?hotel_code=" + hotel_code,
	    type: "GET",
	    dataType: "json",
	    success: function (response) {
	      	var reviewListHtml = "";
	      	var reviewList = response.reviewList;

	      	if (reviewList.length === 0) {
	          	reviewListHtml = "<p>작성된 리뷰가 없습니다!</p>";
	      	} else {
	        	for (var i = 0; i < reviewList.length; i++) {
	        		var review = reviewList[i];
                    reviewListHtml += '<div class="reviewItem">';
                    reviewListHtml += '<img src="/resources/images/profile.png" alt="Profile" width="40" height="40" style="margin-right: 10px;"/>' + review.mem_name;
                    reviewListHtml += "<h5>" + review.room_name + " | " + review.mem_name + "</h5>";
                    reviewListHtml += '<div class="rating_star" data-score="' + review.rating_value + '"></div>';
                    reviewListHtml += '<div class="content"><p>' + review.content + "</p></div>";
	        		
		          	
		         	// 이미지 처리
		          	if (review.imageDTO.length == 0) {
		        	  	reviewListHtml += '<span></span>';
		          	} else {
		          		reviewListHtml += '<div class="imageList">';
		          
		        	  	for (var j = 0; j < review.imageDTO.length; j++) {
		  	            	var image = review.imageDTO[j];
		  	            	
		  	            	reviewListHtml += '<img src=".' + image.filepath + '" alt="' + image.filename + '" width="180" height="140" />';
		  	          	}
		        	  	
		        	  	reviewListHtml += "</div>";
		          	}

		          	reviewListHtml += '<input type="button" id="update" data-review-code="' + review.review_code + '"value="수정" />';
		          	reviewListHtml += '<input type="button" id="delete" data-review-code="' + review.review_code + '"value="삭제" />';
		          	
		          	reviewListHtml += '<input type="button" id="commentBtn" data-review-code="' + review.review_code + '"value="COMMENT" />';
		          	
		          	if (review.business_comment) {
		                reviewListHtml += '<div class="business-comment">';
		                reviewListHtml += '<i class="fas fa-arrow-right">' + "    " + '</i>';
		                reviewListHtml += '<div><span style="margin-left:10px;">' + review.business_comment + '</span></div>';
		                reviewListHtml += '</div>';
		            }
		          	
		          	reviewListHtml += "</div>";
		          	reviewListHtml += "<hr/>";
	        	}
		        // update rating
		        var rating = response.rating;
		        $("#rating_avg_2").html('<div class="rating_star" data-score="' + rating.rating_avg + '"></div><div>평균 평점 ' + rating.rating_avg + '</div>');
		        $("#rating_cnt").html("<p>작성된 리뷰 " + rating.rating_cnt + "</p>");
	      	}
	      	$("#reviewList").html(reviewListHtml);
	      
		    // Raty 별점
		    $(".rating_star").each(function() {
	    	    var score = $(this).data("score");
	    	    $(this).raty({
	    	        readOnly: true,
	    	        half: true,
	    	        score: score,
	    	        path: 'https://cdnjs.cloudflare.com/ajax/libs/raty/2.8.0/images/'
	    	    });
		    });
	    },
	});
}

// 폼 양식 clear
function clearForm(formId) {
	$("#" + formId)
	    .find("input[type='text'], textarea, input[type='file'], input[type='password'], input[type='number'], input[type='date']")
	    .val("");
	$("#" + formId)
	    .find("input[type='checkbox'], input[type='radio']")
	    .prop("checked", false);
	$("#" + formId)
	    .find("select")
	    .prop("selectedIndex", 0);
}


$(document).ready(function () {
	// 리뷰 리스트 불러오기
  	loadReviewList(hotel_code);

  	// 리뷰 작성 폼 불러오기
  	$("#writeBtn").on("click", function () {
   		$("#reviewFormContainer").show();
  	});

  	// 리뷰 작성 요청
  	$("#insert").on("click", function () {
    	var formData = new FormData($("#reviewFrm")[0]);

	    $.ajax({
	      	url: "/insertReview",
	      	type: "POST",
	      	data: formData,
	      	processData: false,
	      	contentType: false,
	      	success: function (response) {
	        	if (response == "success") {
	          		loadReviewList(hotel_code);
	        	}
	      	}
	    });
	    clearForm("reviewFrm");
	    $("#reviewFormContainer").hide();
  	});
  	
 	// raty 별점
  	$(".rating-clickable").raty({
  	    half: false,
  	    size: 20,
  	    path: 'https://cdnjs.cloudflare.com/ajax/libs/raty/2.8.0/images/',
  	    click: function(score, event) {
  	        $("#rating_value").val(score);
  	    }
  	});
  	
});

//리뷰 수정 폼 불러오기
$(document).on('click', '#update', function () {
	// 다른 리뷰 눌렀을때 현재 리뷰 수정 폼 숨기기
	$(".editFormContainer").remove();
	$(".reviewItem:hidden").show();
	
    var reviewDiv = $(this).closest('.reviewItem');
    var review_code = $(this).data('review-code');
    var content = reviewDiv.find('.content').text();
    var rating_value = reviewDiv.data('score');
    var existingImages = reviewDiv.find('.imageList img');
    var existingFilenames = [];
    
    // 현재 리뷰 숨기기
    reviewDiv.hide();

    existingImages.each(function () {
        var img = $(this).clone();
        var filename = img.attr('alt');
        existingFilenames.push(filename);
    });
        
    var editForm = '<div id="editFormContainer' + review_code + '" class="editFormContainer">';
    editForm += '<form id="editForm" data-review-code="' + review_code + '" enctype="multipart/form-data">';
    editForm += '<div>content<textarea id="editContent" name="content">' + content + '</textarea></div>';
   	
    editForm += '<div>rating<input type="hidden" id="editRatingValue" name="editRatingValue">';
   	editForm += '<div class="rating-clickable"></div>';

	editForm += '<div>기존 첨부파일' + existingFilenames.join(', ') + '</div>';
    editForm += '<div><input type="file" id="editImages" name="editImages" multiple /></div>';
    editForm += '<input type="button" id="submitEdit" value="완료" />';
    editForm += '<input type="button" id="cancelEdit" value="취소" />';
    editForm += '</form>';
    editForm += '</div>';
	
    // 숨겨진 리뷰 다음 리뷰 수정 폼 출력
    reviewDiv.after(editForm);
    
    // raty
    $("#editFormContainer" + review_code + " .rating-clickable").raty({
        half: false,
        size: 20,
        path: 'https://cdnjs.cloudflare.com/ajax/libs/raty/2.8.0/images/',
        click: function(score, event) {
            $("#editRatingValue").val(score);
        },
        score: rating_value
    });
});

// 리뷰 수정 요청
$(document).on('click', '#submitEdit', function () {
	var form = $(this).closest('form');
    var review_code = form.data('review-code');
    var editedContent = form.find('#editContent').val();
    var editedRatingValue = form.find('#editRatingValue').val();

 	// Create FormData object to handle file uploads
    var formData = new FormData();
    formData.append('review_code', review_code);
    formData.append('content', editedContent);
    formData.append('rating_value', editedRatingValue);

    // Handle file uploads
    var editImages = form.find('#editImages')[0].files;
    for (var i = 0; i < editImages.length; i++) {
        formData.append('images', editImages[i]);
    }
    
    $.ajax({
        url: '/updateReview',
        type: 'POST',
        processData: false,
        contentType: false, // formData로 바꿨으니까 false 줘야함
        // contentType: 'application/json', // Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported
        data: formData,
        beforeSend: function (xhr) {
            xhr.setRequestHeader("X-HTTP-Method-Override", "PUT"); // multipart/form-data은 put을 지원하지 않음
        },
        success: function (response) {
            if (response == 'success') {
                loadReviewList(hotel_code);
                
                $('#editFormContainer' + review_code).remove();
                $('.review').show();
            }
        }
    });
});

//리뷰 삭제
$(document).on('click', '#delete', function() {
	var review_code = $(this).data('review-code');
    	
   	if (confirm('정말로 삭제하시겠습니까?')) {
   		$.ajax({
   			url: '/deleteReview?review_code=' + review_code,
   			type: 'DELETE',
   			success: function(response) {
   				loadReviewList(hotel_code);
   			}
   		});
   	}
});









// 사업자 댓글 폼 불러오기
$(document).on('click', '#commentBtn', function() {
	var reviewDiv = $(this).closest('.reviewItem');
    var review_code = $(this).data('review-code');
    
    $("#current_review_code").val(review_code);
    $("#commentFormContainer").insertAfter(reviewDiv);
    $("#commentFormContainer").show();
});

// 사업자 댓글 작성 요청
$(document).on('click', '#submitComment', function() {
	var business_comment = $("#business_comment").val();
    var review_code = $("#current_review_code").val();
    
    console.log("review_code:", review_code);
    
    $.ajax({
    	url: '/insertBusinessComment',
    	type: 'PUT',
    	contentType: 'application/json',
        data: JSON.stringify({ review_code: review_code, business_comment: business_comment }),
    	success: function(response) {
    		loadReviewList(hotel_code);
    	}
    });
});

// 리뷰 작성 중 취소 요청
$(document).on('click', '#cancelInsert', function () {
	$('#reviewFormContainer').hide();
  clearForm("reviewFrm");
});

// 리뷰 수정 중 취소 요청
$(document).on('click', '#cancelEdit', function () {
	// 리뷰 수정 폼만 동적으로 생성되기 때문에 dom 순서를 위해 show/remove 여기서 조절해야함
	$(".editFormContainer").remove();
	$(".reviewItem:hidden").show();
});

// 사업자 댓글 작성 중 취소 요청
$(document).on('click', '#cancelComment', function () {
	$("#commentFormContainer").hide();
	clearForm("commentFrm");
});
