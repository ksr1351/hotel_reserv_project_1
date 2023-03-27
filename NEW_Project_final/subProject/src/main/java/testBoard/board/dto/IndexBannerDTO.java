package testBoard.board.dto;

public class IndexBannerDTO {
 
	private int hotel_code;
	private String filename;
	private String filepath;
	private double rating_avg;
	private String name;
	private String address;
	
	public IndexBannerDTO() {
	
	}

	public IndexBannerDTO(int hotel_code, String filename, String filepath, double rating_avg, String name,
			String address) {
		this.hotel_code = hotel_code;
		this.filename = filename;
		this.filepath = filepath;
		this.rating_avg = rating_avg;
		this.name = name;
		this.address = address;
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

	public double getRating_avg() {
		return rating_avg;
	}

	public void setRating_avg(double rating_avg) {
		this.rating_avg = rating_avg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "IndexBannerDTO [hotel_code=" + hotel_code + ", filename=" + filename + ", filepath=" + filepath
				+ ", rating_avg=" + rating_avg + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
	
}
