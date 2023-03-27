package testBoard.board.dto;

import java.util.Objects;

public class Hotel_infoDTO {

	private String info;
	
	public Hotel_infoDTO() {
	}

	public Hotel_infoDTO(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	
	
	
	@Override
	public int hashCode() {
		
		return Objects.hash(info);
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass())return false;
		
		Hotel_infoDTO infoDTO = (Hotel_infoDTO) obj;
		
		
		return Objects.equals(info,infoDTO.info);
	}

	@Override
	public String toString() {
		return "Hotel_infoDTO [info=" + info + "]";
	}
	
	
	
	
	
}
