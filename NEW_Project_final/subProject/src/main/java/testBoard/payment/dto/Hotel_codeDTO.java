package testBoard.payment.dto;

public class Hotel_codeDTO {

	private int hotel_code;
	
	public Hotel_codeDTO() {
		// TODO Auto-generated constructor stub
	}

	public Hotel_codeDTO(int hotel_code) {
		super();
		this.hotel_code = hotel_code;
	}

	public int getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(int hotel_code) {
		this.hotel_code = hotel_code;
	}

	@Override
	public String toString() {
		return "Hotel_codeDTO [hotel_code=" + hotel_code + "]";
	}
	
	
	
}
