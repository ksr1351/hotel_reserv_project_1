package webCrawlig.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Room_SubInfoDTO {
	
	private int hotel_code;
	private int room_code;
	
	private String roomName;
	private String SubInfo;
	private String price;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
		
	public Room_SubInfoDTO() {
	
	}

	
	
	public Room_SubInfoDTO(int hotel_code, String roomName, String subInfo, String price) {
		this.hotel_code = hotel_code;
		this.roomName = roomName;
		this.SubInfo = subInfo;
		this.price = price;
	}



	public int getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(int hotel_code) {
		this.hotel_code = hotel_code;
	}

	public int getRoom_code() {
		return room_code;
	}

	public void setRoom_code(int room_code) {
		this.room_code = room_code;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getSubInfo() {
		return SubInfo;
	}

	public void setSubInfo(String subInfo) {
		SubInfo = subInfo;
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
		return "Room_SubInfoDTO [hotel_code=" + hotel_code + ", room_code=" + room_code + ", roomName=" + roomName
				+ ", SubInfo=" + SubInfo + ", price=" + price + ", regdate=" + regdate + "]";
	}



	
	
	

	
	
}
