package webCrawlig.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RoomDTO {
		
	private int hotel_code;
	
	private String info;
	private String detail_info;
	
	//DB 아직 안들어감
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	public RoomDTO() {

	}

	public RoomDTO(int hotel_code, String info, String detail_info) {
		this.hotel_code = hotel_code;
		this.info = info;
		this.detail_info = detail_info;
	
	}

	
	
	
	
	public int getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(int hotel_code) {
		this.hotel_code = hotel_code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDetail_info() {
		return detail_info;
	}

	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}

	
	
	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "RoomDTO [hotel_code=" + hotel_code + ", info=" + info + ", detail_info=" + detail_info + ", regdate="
				+ regdate + "]";
	}

	
	
	
	

}
