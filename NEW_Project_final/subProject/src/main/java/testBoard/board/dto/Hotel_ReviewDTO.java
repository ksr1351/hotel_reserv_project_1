package testBoard.board.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;



	public class Hotel_ReviewDTO {
	   // private int review_code;
	   private Integer review_code; // 동적으로 생성된 review_code를 사용하기 위해
	   private int booking_code;
	   private String content;
	   private int rating_value;
	   private String business_comment;
	   
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	   private Date regdate;
	   
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	   private Date moddate;
	   
//	   private String filename;
//	   private String filepath;
	   
	   private List<ImageDTO> imageDTO;
	   
	   private String mem_name; // 고객테이블 > 고객명
	   private String room_name; // 객실테이블 > 객실명
	   
	//   private int hotel_code;
	//   private int mem_code;
	   private String status; // 예약테이블 > 상태
	   private Date checkout; // 예약테이블 > 체크아웃날짜
	   
	   public Hotel_ReviewDTO() {
	   }
	   
	   public Hotel_ReviewDTO(Integer review_code, int booking_code, String content, int rating_value, Date regdate,
	         Date moddate, String filename, String filepath, String mem_name, String room_name, String status,
	         Date checkout,List<ImageDTO> imageDTO, String business_comment) {
	      this.review_code = review_code;
	      this.booking_code = booking_code;
	      this.content = content;
	      this.rating_value = rating_value;
	      this.regdate = regdate;
	      this.moddate = moddate;
	      this.mem_name = mem_name;
	      this.room_name = room_name;
	      this.status = status;
	      this.checkout = checkout;
	      this.imageDTO = imageDTO;
	      this.business_comment = business_comment;
	   }

	   
	   
	   public List<ImageDTO> getImageDTO() {
		return imageDTO;
	}

	public void setImageDTO(List<ImageDTO> imageDTO) {
		this.imageDTO = imageDTO;
	}

	public Integer getReview_code() {
	      return review_code;
	   }
	   
	   public void setReview_code(Integer review_code) {
	      this.review_code = review_code;
	   }
	   
	   public int getBooking_code() {
	      return booking_code;
	   }
	   
	   public void setBooking_code(int booking_code) {
	      this.booking_code = booking_code;
	   }
	   
	   public String getContent() {
	      return content;
	   }
	   
	   public void setContent(String content) {
	      this.content = content;
	   }
	   
	   public int getRating_value() {
	      return rating_value;
	   }
	   
	   public void setRating_value(int rating_value) {
	      this.rating_value = rating_value;
	   }
	   
	   public Date getRegdate() {
	      return regdate;
	   }
	   
	   public void setRegdate(Date regdate) {
	      this.regdate = regdate;
	   }
	   
	   public Date getModdate() {
	      return moddate;
	   }
	   
	   public void setModdate(Date moddate) {
	      this.moddate = moddate;
	   }
	   
	  
	  
	   
	   public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getRoom_name() {
	      return room_name;
	   }
	   
	   public void setRoom_name(String room_name) {
	      this.room_name = room_name;
	   }
	   
	   public String getStatus() {
	      return status;
	   }
	   
	   public void setStatus(String status) {
	      this.status = status;
	   }
	   
	   public Date getCheckout() {
	      return checkout;
	   }
	   
	   public void setCheckout(Date checkout) {
	      this.checkout = checkout;
	   }

	@Override
	public String toString() {
		return "Hotel_ReviewDTO [review_code=" + review_code + ", booking_code=" + booking_code + ", content=" + content
				+ ", rating_value=" + rating_value + ", regdate=" + regdate + ", moddate=" + moddate + ", imageDTO="
				+ imageDTO + ", mem_name=" + mem_name + ", room_name=" + room_name + ", status=" + status
				+ ", checkout=" + checkout + "]";
	}

	public String getBusiness_comment() {
		return business_comment;
	}

	public void setBusiness_comment(String business_comment) {
		this.business_comment = business_comment;
	}
	   
	
	   
	   
	   
	}
	
	

