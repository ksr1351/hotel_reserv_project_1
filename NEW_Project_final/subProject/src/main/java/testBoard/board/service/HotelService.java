package testBoard.board.service;

import java.util.List;
import java.util.Map;

import testBoard.board.dto.BookingDTO;
import testBoard.board.dto.CheckDTO;
import testBoard.board.dto.Hotel_Banner_InfoDTO;
import testBoard.board.dto.Hotel_Detail_ConDTO;
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

public interface HotelService {
	public List<Hotel_Banner_InfoDTO> hotelListAllProcess();
	public List<Hotel_Banner_InfoDTO> searchHotelListProcess(SearchDTO searchDTO);
	public List<Hotel_Sub_InfoDTO> hotelSubInfoProcess(int hotel_code);
	public List<Room_Banner_InfoDTO> roomListProcess(SearchDTO searchDTO);
	public List<Hotel_Detail_ConDTO> Hotel_Detail_infoProcess(int hotel_code);

	// review
	public List<Hotel_ReviewDTO> hotel_ReviewProcess(int hotel_code);

	public int insertReviewProcess(Hotel_ReviewDTO review, List<ImageDTO> reviewImages);

	public int updateReviewProcess(Hotel_ReviewDTO review, List<ImageDTO> reviewImages);

	public int deleteReviewProcess(int review_code);

	public Map<String, Object> updateRatingProcess(int hotel_code);
	
	public int insertBusinessCommentProcess(Hotel_ReviewDTO review);
	
	public List<managementDTO> managementProcess();
	
	public List<CheckDTO> myPageProcess(int mem_code);

	public PayPageDTO payPageProcess(PayCheckDTO payCheckDTO, SearchDTO searchDTO);
	
	public int PaymentProcess(BookingDTO bookingDTO);
	
	public int bookingCancelProcess(int booking_code);
	
	public List<IndexBannerDTO> indexBannerProcess();
	
	public int KakaoPayCancelProcess(KakaoPayCancelDTO kakaoPayCancelDTO, BookingDTO bookingDTO);
	
	public KakaoPayCancelDTO selectKakaoPayProcess(int booking_code);
	
	public List<BoardFreeDTO> RawnumBoardProcess();
}
