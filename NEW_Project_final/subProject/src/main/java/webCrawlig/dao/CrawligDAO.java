package webCrawlig.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webCrawlig.dto.Hotel_Detail_AddressDTO;
import webCrawlig.dto.Hotel_ImagesDTO;
import webCrawlig.dto.Hotel_banner_InfoDTO;
import webCrawlig.dto.Hotel_convenienceDTO;
import webCrawlig.dto.RoomDTO;
import webCrawlig.dto.Room_ImagesDTO;
import webCrawlig.dto.Room_SubInfoDTO;
import webCrawlig.dto.Room_banner_InfoDTO;

@Component
public class CrawligDAO {
	
	private final SqlSessionTemplate sqlSession;
	
	
	@Autowired
	public CrawligDAO(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}


	
	
	
	public int hotelMathod(Hotel_banner_InfoDTO Hotel_WebCrawligDTO) {
		
		return sqlSession.insert("craw.hotel", Hotel_WebCrawligDTO);
	}
	
	
	public int roomDetailInfoMethod(RoomDTO roomDTO) {
		
		return sqlSession.insert("craw.RoomDetailInfo", roomDTO);
	}
	
	public int roomBannerInfoMethod(Room_banner_InfoDTO Room_banner_InfoDTO) {
		
		return sqlSession.insert("craw.RoomBannerInfo",Room_banner_InfoDTO);
	}
	
/////////////////////                 사진                 /////////////////////////////////

public int hotelImagesMathod(Hotel_ImagesDTO hotel_ImagesDTO) {

return sqlSession.insert("craw.hotelImages", hotel_ImagesDTO);
}

public int hotelSubImagesMathod(Hotel_ImagesDTO hotel_ImagesDTO) {
	
	return sqlSession.insert("craw.hotelSubImages",hotel_ImagesDTO );
	
}

public int roomImagersMathod(Room_ImagesDTO room_ImagesDTO) {
	
	return sqlSession.insert("craw.roomImages",room_ImagesDTO);
}


/////////////////////                 사진                 /////////////////////////////////	
	
	public int hotelDetailAddressMathod(Hotel_Detail_AddressDTO hotel_Detail_AddressDTO) {
		
		return sqlSession.insert("craw.hotel_detail_address",hotel_Detail_AddressDTO);
		
	}
	
	
	public int hotel_convenMathod(Hotel_convenienceDTO hotel_convenienceDTO) {
		
		return sqlSession.insert("craw.hotel_conven",hotel_convenienceDTO);
	}

}
