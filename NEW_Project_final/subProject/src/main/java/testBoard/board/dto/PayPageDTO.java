package testBoard.board.dto;

import java.util.Date;

public class PayPageDTO {
	
	
	private int room_code;
	private int hotel_code;
	private int mem_code;
	
	private String name;
	private String room_name;
	private String room_price;
	
	private String filename;
	private String filepath;
	
	private Date checkin;
	private Date checkout;
	
	private int days;
	private String totalPrice;
	
	public PayPageDTO() {
	
	}

	public PayPageDTO(int room_code, int hotel_code, int mem_code, String name, String room_name, String room_price,
			String filename, String filepath, Date checkin, Date checkout, int days, String totalPrice) {
		this.room_code = room_code;
		this.hotel_code = hotel_code;
		this.mem_code = mem_code;
		this.name = name;
		this.room_name = room_name;
		this.room_price = room_price;
		this.filename = filename;
		this.filepath = filepath;
		this.checkin = checkin;
		this.checkout = checkout;
		this.days = days;
		this.totalPrice = totalPrice;
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

	public int getMem_code() {
		return mem_code;
	}

	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "PayPageDTO [room_code=" + room_code + ", hotel_code=" + hotel_code + ", mem_code=" + mem_code
				+ ", name=" + name + ", room_name=" + room_name + ", room_price=" + room_price + ", filename="
				+ filename + ", filepath=" + filepath + ", checkin=" + checkin + ", checkout=" + checkout + ", days="
				+ days + ", totalPrice=" + totalPrice + "]";
	}

    

	
	
	
	
	
}
