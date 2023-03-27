package webCrawlig.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Room_ImagesDTO {
		
	private int room_code;
	private int hotel_code;
	private String filename;
	private String filepath;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	public Room_ImagesDTO() {

	}

	public Room_ImagesDTO(int room_code, int hotel_code, String filename, String filepath) {
		this.room_code = room_code;
		this.hotel_code = hotel_code;
		this.filename = filename;
		this.filepath = filepath;
	
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
		return "Room_ImagesDTO [room_code=" + room_code + ", hotel_code=" + hotel_code + ", filename=" + filename
				+ ", filepath=" + filepath + ", regdate=" + regdate + "]";
	}


	
	
	
	
	
}
