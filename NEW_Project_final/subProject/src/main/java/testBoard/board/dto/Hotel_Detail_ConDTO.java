package testBoard.board.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Hotel_Detail_ConDTO {

	private int hotel_code;
	
	private String hotel_detail_con;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	private List<Hotel_Detail_InfoDTO> hotel_detail_InfoDTO;
	
	public Hotel_Detail_ConDTO() {
	}

	public Hotel_Detail_ConDTO(int hotel_code, String hotel_detail_con) {
		this.hotel_code = hotel_code;
		this.hotel_detail_con = hotel_detail_con;
	}

	
	
	public Hotel_Detail_ConDTO(int hotel_code, String hotel_detail_con, Date regdate,
			List<Hotel_Detail_InfoDTO> hotel_detail_InfoDTO) {
		this.hotel_code = hotel_code;
		this.hotel_detail_con = hotel_detail_con;
		this.regdate = regdate;
		this.hotel_detail_InfoDTO = hotel_detail_InfoDTO;
	}

	public List<Hotel_Detail_InfoDTO> getHotel_detail_InfoDTO() {
		return hotel_detail_InfoDTO;
	}

	public void setHotel_detail_InfoDTO(List<Hotel_Detail_InfoDTO> hotel_detail_InfoDTO) {
		this.hotel_detail_InfoDTO = hotel_detail_InfoDTO;
	}

	public int getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(int hotel_code) {
		this.hotel_code = hotel_code;
	}

	public String getHotel_detail_con() {
		return hotel_detail_con;
	}

	public void setHotel_detail_con(String hotel_detail_con) {
		this.hotel_detail_con = hotel_detail_con;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Hotel_detail_Con [hotel_code=" + hotel_code + ", hotel_detail_con=" + hotel_detail_con + ", regdate="
				+ regdate + "]";
	}
	
	
	
}
