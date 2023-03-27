package testBoard.board.dto;

import java.util.List;

// hotel_banner_info, hotel_detail_address, hotel_sub_images, rating

public class Hotel_Sub_InfoDTO {
	private int hotel_code;
	private String name;
	private String type;
	
	private String hotel_detail_address;
	
//	private String filename;
//	private String filepath;
	private List<ImageDTO> imageDTO;
	
	private double rating_avg;
	
	public Hotel_Sub_InfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public Hotel_Sub_InfoDTO(int hotel_code, String name, String type, String hotel_detail_address, List<ImageDTO> imageDTO,
			double rating_avg) {
		this.hotel_code = hotel_code;
		this.name = name;
		this.type = type;
		this.hotel_detail_address = hotel_detail_address;
		this.imageDTO = imageDTO;
		this.rating_avg = rating_avg;
	}

	public int getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(int hotel_code) {
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

	public String getHotel_detail_address() {
		return hotel_detail_address;
	}

	public void setHotel_detail_address(String hotel_detail_address) {
		this.hotel_detail_address = hotel_detail_address;
	}

	public double getRating_avg() {
		return rating_avg;
	}

	public void setRating_avg(double rating_avg) {
		this.rating_avg = rating_avg;
	}

	public List<ImageDTO> getImageDTO() {
		return imageDTO;
	}

	public void setImageDTO(List<ImageDTO> imageDTO) {
		this.imageDTO = imageDTO;
	}

	@Override
	public String toString() {
		return "Hotel_Sub_InfoDTO [hotel_code=" + hotel_code + ", name=" + name + ", type=" + type
				+ ", hotel_detail_address=" + hotel_detail_address + ", imageDTO=" + imageDTO + ", rating_avg="
				+ rating_avg + "]";
	}
}
