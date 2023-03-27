package testBoard.board.dto;

import java.util.List;

// room_banner_info, room_main_images, 

public class Room_Banner_InfoDTO {
	private int hotel_code;
	private int room_code;
	private String room_name;
	private String room_price;
	private String room_member;
	private String room_width;
	private String room_bed;
	private String totalPrice;
	private int days;

//	private String filename;
//	private String filepath;
	private List<ImageDTO> imageDTO;
	
	public Room_Banner_InfoDTO() {
	
	}

	public Room_Banner_InfoDTO(int hotel_code, int room_code, String room_name, String room_price, String room_member,
			String room_width, String room_bed, String totalPrice, int days, List<ImageDTO> imageDTO) {
		this.hotel_code = hotel_code;
		this.room_code = room_code;
		this.room_name = room_name;
		this.room_price = room_price;
		this.room_member = room_member;
		this.room_width = room_width;
		this.room_bed = room_bed;
		this.totalPrice = totalPrice;
		this.days = days;
		this.imageDTO = imageDTO;
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

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public List<ImageDTO> getImageDTO() {
		return imageDTO;
	}

	public void setImageDTO(List<ImageDTO> imageDTO) {
		this.imageDTO = imageDTO;
	}

	@Override
	public String toString() {
		return "Room_Banner_InfoDTO [hotel_code=" + hotel_code + ", room_code=" + room_code + ", room_name=" + room_name
				+ ", room_price=" + room_price + ", room_member=" + room_member + ", room_width=" + room_width
				+ ", room_bed=" + room_bed + ", totalPrice=" + totalPrice + ", days=" + days + ", imageDTO=" + imageDTO
				+ "]";
	}

	
	
	
}	
