package webCrawlig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webCrawlig.dao.CrawligDAO;
import webCrawlig.dto.Hotel_Detail_AddressDTO;
import webCrawlig.dto.Hotel_ImagesDTO;
import webCrawlig.dto.Hotel_banner_InfoDTO;
import webCrawlig.dto.Hotel_convenienceDTO;
import webCrawlig.dto.RoomDTO;
import webCrawlig.dto.Room_ImagesDTO;
import webCrawlig.dto.Room_SubInfoDTO;
import webCrawlig.dto.Room_banner_InfoDTO;

@Service
public class CrawligService {

	private final CrawligDAO dao;
	
	@Autowired
	public CrawligService(CrawligDAO dao) {
		this.dao = dao;
	}




	
	public int hotelProcess(Hotel_banner_InfoDTO Hotel_WebCrawligDTO) {
		
		return dao.hotelMathod(Hotel_WebCrawligDTO);
	}
	
	public int roomDetailInfoProcess(RoomDTO roomDTO) {
		
		return dao.roomDetailInfoMethod(roomDTO);
		
	}
	
	public int roomBannerInfoProcess(Room_banner_InfoDTO Room_banner_InfoDTO) {
		return dao.roomBannerInfoMethod(Room_banner_InfoDTO);
	}
	
/////////////////////                 사진                 /////////////////////////////////
	
	
	

	public int hotelImagesProcess(Hotel_ImagesDTO hotel_ImagesDTO) {
		
		return dao.hotelImagesMathod(hotel_ImagesDTO);
	}
	
	public int hotelSubImagesProcess(Hotel_ImagesDTO hotel_ImagesDTO) {
		
		return dao.hotelSubImagesMathod(hotel_ImagesDTO);
	}
	
	public int roomImagesProcess(Room_ImagesDTO room_ImagesDTO) {
		
		return dao.roomImagersMathod(room_ImagesDTO);
	}
	
	
	
	
	
/////////////////////                 사진                 /////////////////////////////////
	
	
	public int hotelDetailAddressProcess(Hotel_Detail_AddressDTO hotel_Detail_AddressDTO) {
		
		return dao.hotelDetailAddressMathod(hotel_Detail_AddressDTO);
	}
	
	public int hotelConvenProcess(Hotel_convenienceDTO hotel_convenienceDTO) {
		
		
		return dao.hotel_convenMathod(hotel_convenienceDTO);
	}
	
}

