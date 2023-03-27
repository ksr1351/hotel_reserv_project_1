package webCrawlig.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Room_banner_InfoDTO {

	
	private int hotel_code;
	private int room_code;
	private String room_name;
	private String room_price;
	private String room_member;
	private String room_width;
	private String room_bed;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	public Room_banner_InfoDTO() {
	
	}

	public Room_banner_InfoDTO(int hotel_code, String room_name, String room_price, String room_member,
			String room_width, String room_bed) {
		
		this.hotel_code = hotel_code;
		
		this.room_name = room_name;
		this.room_price = room_price;
		this.room_member = room_member;
		this.room_width = room_width;
		this.room_bed = room_bed;
		
	}

	public int getRoom_code() {
		return room_code;
	}

	public void setRoom_code(int room_code) {
		this.room_code = room_code;
	}

	public int getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(int hotel_code) {
		this.hotel_code = hotel_code;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getRoom_price() {
		return room_price;
	}

	public void setRoom_price(String room_price) {
		this.room_price = room_price;
	}

	public String getRoom_member() {
		return room_member;
	}

	public void setRoom_member(String room_member) {
		this.room_member = room_member;
	}

	public String getRoom_width() {
		return room_width;
	}

	public void setRoom_width(String room_width) {
		this.room_width = room_width;
	}

	public String getRoom_bed() {
		return room_bed;
	}

	public void setRoom_bed(String room_bed) {
		this.room_bed = room_bed;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Room_banner_InfoDTO [room_code=" + room_code + ", hotel_code=" + hotel_code + ", room_name=" + room_name
				+ ", room_price=" + room_price + ", room_member=" + room_member + ", room_width=" + room_width
				+ ", room_bed=" + room_bed + ", regdate=" + regdate + "]";
	} 
	
	
	
	
	
}
