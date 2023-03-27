package testBoard.board.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

// hotel_banner_info, hotel_main_images, rating

public class Hotel_Banner_InfoDTO {
	private int hotel_code;
	private String name;
	private String type;
	private String address;
	private String price;
	
	private String filename;
	private String filepath;
	
	private double rating_avg;
	private int rating_cnt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	

	
	public Hotel_Banner_InfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public Hotel_Banner_InfoDTO(int hotel_code, String name, String type, String address, String price, String filename,
			String filepath, double rating_avg, int rating_cnt) {
		this.hotel_code = hotel_code;
		this.name = name;
		this.type = type;
		this.address = address;
		this.price = price;
		this.filename = filename;
		this.filepath = filepath;
		this.rating_avg = rating_avg;
		this.rating_cnt = rating_cnt;
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public double getRating_avg() {
		return rating_avg;
	}

	public void setRating_avg(double rating_avg) {
		this.rating_avg = rating_avg;
	}

	public int getRating_cnt() {
		return rating_cnt;
	}

	public void setRating_cnt(int rating_cnt) {
		this.rating_cnt = rating_cnt;
	}

	@Override
	public String toString() {
		return "Hotel_Banner_InfoDTO [hotel_code=" + hotel_code + ", name=" + name + ", type=" + type + ", address="
				+ address + ", price=" + price + ", filename=" + filename + ", filepath=" + filepath + ", rating_avg="
				+ rating_avg + ", rating_cnt=" + rating_cnt + "]";
	}
	
	
}
