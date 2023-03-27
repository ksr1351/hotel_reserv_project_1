package webCrawlig.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Hotel_ImagesDTO {
	
	private int hotel_code;
	
	private String filename;
	private String filepath;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	
	public Hotel_ImagesDTO() {
	
	}
	
	public Hotel_ImagesDTO(String filename, String filepath) {
		this.filename = filename;
		this.filepath = filepath;
		
	}

	public Hotel_ImagesDTO(int Hotel_code,String filename, String filepath) {
		this.hotel_code = Hotel_code;
		this.filename = filename;
		this.filepath = filepath;
		
	}

	


	public int getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(int hotel_code) {
		this.hotel_code = hotel_code;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Hotel_ImagesDTO [hotel_code=" + hotel_code + ", filename=" + filename + ", filepath=" + filepath
				+ ", regdate=" + regdate + "]";
	}



	
}
