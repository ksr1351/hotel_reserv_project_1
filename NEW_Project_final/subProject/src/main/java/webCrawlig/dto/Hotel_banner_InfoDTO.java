package webCrawlig.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Hotel_banner_InfoDTO {
		
	private long hotel_code;
	
	private String name;
	private String type;
	private String address;
	private String price;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	 
	public Hotel_banner_InfoDTO() {

	}


	public Hotel_banner_InfoDTO( String name, String type, String address, String price) {
		
		this.name = name;
		this.type = type;
		this.address = address;
		this.price = price;
	}


	public long getHotel_code() {
		return hotel_code;
	}


	public void setHotel_code(long hotel_code) {
		this.hotel_code = hotel_code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	@Override
	public String toString() {
		return "Hotel_WebCrawligDTO [hotel_code=" + hotel_code + ", name=" + name + ", type=" + type + ", address="
				+ address + ", price=" + price + ", regdate=" + regdate + "]";
	}

	
	
	
	
}
