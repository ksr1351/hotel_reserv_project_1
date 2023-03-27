package testBoard.board.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BookingDTO {

	private int booking_code;
	private int mem_code;
	private int hotel_code;
	private int room_code;
	
	private int guests;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkin;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkout;
	
	private char status;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date canceldate ;

	public int getBooking_code() {
		return booking_code;
	}

	public BookingDTO() {
	}
	
	
	
	
	public BookingDTO(int booking_code, int mem_code, int hotel_code, int room_code, int guests, Date checkin,
			Date checkout, char status, Date regdate, Date canceldate) {
		this.booking_code = booking_code;
		this.mem_code = mem_code;
		this.hotel_code = hotel_code;
		this.room_code = room_code;
		this.guests = guests;
		this.checkin = checkin;
		this.checkout = checkout;
		this.status = status;
		this.regdate = regdate;
		this.canceldate = canceldate;
	}

	public void setBooking_code(int booking_code) {
		this.booking_code = booking_code;
	}

	public int getMem_code() {
		return mem_code;
	}

	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
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

	public int getGuests() {
		return guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
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

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getCanceldate() {
		return canceldate;
	}

	public void setCanceldate(Date canceldate) {
		this.canceldate = canceldate;
	}

	@Override
	public String toString() {
		return "BookingDTO [booking_code=" + booking_code + ", mem_code=" + mem_code + ", hotel_code=" + hotel_code
				+ ", room_code=" + room_code + ", guests=" + guests + ", checkin=" + checkin + ", checkout=" + checkout
				+ ", status=" + status + ", regdate=" + regdate + ", canceldate=" + canceldate + "]";
	}
	
	
	
	
}
