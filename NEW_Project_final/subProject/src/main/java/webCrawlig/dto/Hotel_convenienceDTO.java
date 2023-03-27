package webCrawlig.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Hotel_convenienceDTO {

	private int hotel_code;
	
	private String hotel_detail_con;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	public Hotel_convenienceDTO() {
	}

	public Hotel_convenienceDTO(int hotel_code, String hotel_detail_con) {
		this.hotel_code = hotel_code;
		this.hotel_detail_con = hotel_detail_con;
		
	}

	public int getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(int hotel_code) {
		this.hotel_code = hotel_code;
	}

	public String getHotel_detail_con() {
		return hotel_detail_con;
	}

	public void setHotel_detail_con(String hotel_detail_con) {
		this.hotel_detail_con = hotel_detail_con;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Hotel_convenienceDTO [hotel_code=" + hotel_code + ", hotel_detail_con=" + hotel_detail_con
				+ ", regdate=" + regdate + "]";
	}
	
	
	
}
