package testBoard.board.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class managementDTO {

	private int booking_code;
	private String name;
	private String room_name;
	private String mem_Phone; 
	private String mem_Name;
	private String room_price;
	
	private int days;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkin;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkout;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date canceldate;
	
	public managementDTO() {
	}

	public managementDTO(int booking_code, String name, String room_name, String mem_Phone, String mem_Name,
			String room_price, int days, Date regdate, Date checkin, Date checkout, Date canceldate) {
		this.booking_code = booking_code;
		this.name = name;
		this.room_name = room_name;
		this.mem_Phone = mem_Phone;
		this.mem_Name = mem_Name;
		this.room_price = room_price;
		this.days = days;
		this.regdate = regdate;
		this.checkin = checkin;
		this.checkout = checkout;
		this.canceldate = canceldate;
	}

	public int getBooking_code() {
		return booking_code;
	}

	public void setBooking_code(int booking_code) {
		this.booking_code = booking_code;
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

	public String getMem_Phone() {
		return mem_Phone;
	}

	public void setMem_Phone(String mem_Phone) {
		this.mem_Phone = mem_Phone;
	}

	public String getMem_Name() {
		return mem_Name;
	}

	public void setMem_Name(String mem_Name) {
		this.mem_Name = mem_Name;
	}

	public String getRoom_price() {
		return room_price;
	}

	public void setRoom_price(String room_price) {
		this.room_price = room_price;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
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

	public Date getCanceldate() {
		return canceldate;
	}

	public void setCanceldate(Date canceldate) {
		this.canceldate = canceldate;
	}

	@Override
	public String toString() {
		return "managementDTO [booking_code=" + booking_code + ", name=" + name + ", room_name=" + room_name
				+ ", mem_Phone=" + mem_Phone + ", mem_Name=" + mem_Name + ", room_price=" + room_price + ", days="
				+ days + ", regdate=" + regdate + ", checkin=" + checkin + ", checkout=" + checkout + ", canceldate="
				+ canceldate + "]";
	}

	
	
	
	
	
	
	
}
