package testBoard.board.service;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import testBoard.board.dao.HotelDAO;
import testBoard.board.dto.BookingDTO;
import testBoard.board.dto.CheckDTO;

import testBoard.board.dto.Hotel_Banner_InfoDTO;
import testBoard.board.dto.Hotel_Detail_ConDTO;
import testBoard.board.dto.Hotel_RatingDTO;
import testBoard.board.dto.Hotel_ReviewDTO;
import testBoard.board.dto.Hotel_Sub_InfoDTO;
import testBoard.board.dto.ImageDTO;
import testBoard.board.dto.IndexBannerDTO;
import testBoard.board.dto.PayCheckDTO;
import testBoard.board.dto.PayPageDTO;
import testBoard.board.dto.Room_Banner_InfoDTO;
import testBoard.board.dto.SearchDTO;
import testBoard.board.dto.managementDTO;
import testBoard.free.dto.BoardFreeDTO;
import testBoard.payment.dto.KakaoPayCancelDTO;



@Service
public class HotelServiceImp implements HotelService {
	
	private final HotelDAO hotelDAO;
	
	@Autowired
	public HotelServiceImp(HotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}

	@Override
	public List<Hotel_Banner_InfoDTO> hotelListAllProcess() {
		return hotelDAO.hotelListAll();
	}

	@Override
	public List<Hotel_Banner_InfoDTO> searchHotelListProcess(SearchDTO searchDTO) {
		return hotelDAO.searchHotelList(searchDTO);
	}

	
	// room > rel
	
	@Override
	public List<Hotel_Sub_InfoDTO> hotelSubInfoProcess(int hotel_code) {
		return hotelDAO.hotelSubInfo(hotel_code);
	}

	@Override
	public List<Room_Banner_InfoDTO> roomListProcess(SearchDTO searchDTO) {
		
		List<Room_Banner_InfoDTO> roomList = hotelDAO.roomList(searchDTO);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d1;
		
		Date d2;
		
		long Days;
		
		
		
		if(searchDTO.getCheckin() != "" && searchDTO.getCheckout()!="") {
			
		try {
			
			d1 = formatter.parse(searchDTO.getCheckin());
			d2 = formatter.parse(searchDTO.getCheckout());
			
			Days = ((d2.getTime()-d1.getTime())/(3600000*24));
			
			
			
			
			
			if((int)Days>=1) {
				
					
				roomList=roomList.stream()
					.peek(n-> n.setTotalPrice(
							calculatorMethod(d1, d2, n.getRoom_price())
							)).peek(n->n.setDays((int)Days)).collect(Collectors.toList());
					
					
			}

		} catch (ParseException e) {
			e.getMessage();
			e.printStackTrace();
			
		}
		}
		
		return roomList;
	}

	
	@Override
	public List<Hotel_Detail_ConDTO> Hotel_Detail_infoProcess(int hotel_code) {
		
		return hotelDAO.Hotel_Detail_infoMathod(hotel_code);
	}

	
	
	
	
	// review list
	
	@Override
	public List<Hotel_ReviewDTO> hotel_ReviewProcess(int hotel_code) {
		
		return hotelDAO.Hotel_ReviewMethod(hotel_code);
	}

	@Override
	public int insertReviewProcess(Hotel_ReviewDTO review, List<ImageDTO> reviewImages) {
		
		int result = hotelDAO.insertReview(review);
		 
		if (reviewImages != null && !reviewImages.isEmpty()) {
		       for (ImageDTO reviewImage : reviewImages) {
		          reviewImage.setReview_code(review.getReview_code());
		          hotelDAO.insertReviewImage(reviewImage);
		       }
		    }
	    
		return result;
	
	}
	

	
	@Override
	public int updateReviewProcess(Hotel_ReviewDTO review, List<ImageDTO> reviewImages) {
		
		  hotelDAO.deleteReviewImage(review.getReview_code());
		
		if (reviewImages != null && !reviewImages.isEmpty()) {
		       for (ImageDTO reviewImage : reviewImages) {
		          reviewImage.setReview_code(review.getReview_code());
		          hotelDAO.insertReviewImage(reviewImage);
		       }
		    }
		
		return hotelDAO.updateReview(review);
	}

	@Override
	public int deleteReviewProcess(int review_code) {
		
		hotelDAO.deleteReviewImage(review_code);
		
		return hotelDAO.deleteReview(review_code);
	}

	@Override
	public Map<String, Object> updateRatingProcess(int hotel_code) {
		double avg = hotelDAO.getAvgRating(hotel_code);
		int cnt = hotelDAO.getCntRating(hotel_code);

		Hotel_RatingDTO rating = new Hotel_RatingDTO();
		rating.setHotel_code(hotel_code);
		rating.setRating_avg(avg);
		rating.setRating_cnt(cnt);
		hotelDAO.updateRating(rating);

		Map<String, Object> map = new HashMap<>();
		map.put("rating_avg", avg);
		map.put("rating_cnt", cnt);
		return map;
	}
	
	@Override
	public int insertBusinessCommentProcess(Hotel_ReviewDTO review) {
	      return hotelDAO.insertBusinessComment(review);
	}



	@Override
	public List<managementDTO> managementProcess() {
		
		
		
		return hotelDAO.menagementMethod()
				.stream()
				.peek(n->n.setRoom_price
				(calculatorMethod(n.getCheckin(),n.getCheckout(),n.getRoom_price())))
				.peek(n->n.setDays(
						
						(int)((n.getCheckout().getTime()-n.getCheckin().getTime())/(3600000*24))
						
						)).collect(Collectors.toList());
		
	}

	@Override
	public List<CheckDTO> myPageProcess(int mem_code) {
		
		
		
		
		
		
		
		return hotelDAO.myPageMethod(mem_code)
				.stream()
				.peek(n-> n.setRoom_price(
						calculatorMethod(n.getCheckin(), n.getCheckout(), n.getRoom_price())
						)).peek(n->n.setDays(
								
								(int)((n.getCheckout().getTime()-n.getCheckin().getTime())/(3600000*24))
								
								)).collect(Collectors.toList());
		
	}

	
	private String calculatorMethod(Date checkin, Date checkout, String price) {
		
		
		String date = "";
		
		
		
		long Days = ((checkout.getTime()-checkin.getTime())/(3600000*24));
		
	
		long num = Integer.parseInt(price.substring(0,price.length()-1).replace(",", ""));
		
		long payPrice = (num*Days);
		
		
		DecimalFormat formatter = new DecimalFormat("###,###원");
		
		date =formatter.format(payPrice);
		
		
		
		return date;
	}


	
	public int days(String checkin,String checkout) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		
		Date d1 = formatter.parse(checkin);
		Date d2 = formatter.parse(checkout);
			
		long Days = ((d2.getTime()-d1.getTime())/(3600000*24));
			
		
		return (int)Days;
	}
	
	public Date DateParse(String date) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		
		Date d1 = new Date();
		
		try {
			d1 = formatter.parse(date);
			
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		return d1;
	}

	@Override
	public PayPageDTO payPageProcess(PayCheckDTO payCheckDTO, SearchDTO searchDTO) {
		
		  PayPageDTO payPageDTO= hotelDAO.PayPageMethod(payCheckDTO);
				  
		  System.out.println(payPageDTO);
		  
		payPageDTO.setDays((int)((DateParse(searchDTO.getCheckout()).getTime()-DateParse(searchDTO.getCheckin()).getTime())/(3600000*24)));
	    payPageDTO.setTotalPrice(calculatorMethod(DateParse(searchDTO.getCheckin()), DateParse(searchDTO.getCheckout()), payPageDTO.getRoom_price()));
		payPageDTO.setCheckin(DateParse(searchDTO.getCheckin()));
		payPageDTO.setCheckout(DateParse(searchDTO.getCheckout()));
		
		System.out.println(payPageDTO);
		
		return 	payPageDTO;
				
	}

	@Override
	public int PaymentProcess(BookingDTO bookingDTO) {
		
		return hotelDAO.PaymentMethod(bookingDTO);
	}

	@Override
	public int bookingCancelProcess(int booking_code) {
		
		return hotelDAO.bookingCancelMethod(booking_code);
	}

	@Override
	public List<IndexBannerDTO> indexBannerProcess() {
		
		return hotelDAO.indexBannerMethod();
	}

	@Override
	public int KakaoPayCancelProcess(KakaoPayCancelDTO kakaoPayCancelDTO, BookingDTO bookingDTO) {
		
		hotelDAO.PaymentMethod(bookingDTO);
		
		kakaoPayCancelDTO.setBooking_code(String.valueOf(bookingDTO.getBooking_code()));
		
		
		
		return hotelDAO.KakaoPayCancelMethod(kakaoPayCancelDTO);
	}

	@Override
	public KakaoPayCancelDTO selectKakaoPayProcess(int booking_code) {
		
		return hotelDAO.selectKakaoPayMethod(booking_code);
	}

	@Override
	public List<BoardFreeDTO> RawnumBoardProcess() {
		return hotelDAO.RawnumBoardMethod();
	}
	
}
