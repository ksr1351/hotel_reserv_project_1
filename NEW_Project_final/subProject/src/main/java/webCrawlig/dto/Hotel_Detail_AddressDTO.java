package webCrawlig.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Hotel_Detail_AddressDTO {

	private int hotel_code;
	
	private String hotel_detail_address;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	public Hotel_Detail_AddressDTO() {
	}

	public Hotel_Detail_AddressDTO(int hotel_code, String hotel_detail_address) {
		this.hotel_code = hotel_code;
		this.hotel_detail_address = hotel_detail_address;
		
	}

	public int getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(int hotel_code) {
		this.hotel_code = hotel_code;
	}

	public String getHotel_detail_address() {
		return hotel_detail_address;
	}

	public void setHotel_detail_address(String hotel_detail_address) {
		this.hotel_detail_address = hotel_detail_address;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Hotel_Detail_AddressDTO [hotel_code=" + hotel_code + ", hotel_detail_address=" + hotel_detail_address
				+ ", regdate=" + regdate + "]";
	}

	

}
