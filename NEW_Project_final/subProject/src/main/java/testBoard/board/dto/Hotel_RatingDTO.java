package testBoard.board.dto;

public class Hotel_RatingDTO {
	private int hotel_code;
	private double rating_avg;
	private int rating_cnt;
	
	public Hotel_RatingDTO() {
	}
	
	public Hotel_RatingDTO(int hotel_code, double rating_avg, int rating_cnt) {
		this.hotel_code = hotel_code;
		this.rating_avg = rating_avg;
		this.rating_cnt = rating_cnt;
	}

	public int getHotel_code() {
		return hotel_code;
	}

	public void setHotel_code(int hotel_code) {
		this.hotel_code = hotel_code;
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
		return "Hotel_RatingDTO [hotel_code=" + hotel_code + ", rating_avg=" + rating_avg + ", rating_cnt=" + rating_cnt
				+ "]";
	}
}
